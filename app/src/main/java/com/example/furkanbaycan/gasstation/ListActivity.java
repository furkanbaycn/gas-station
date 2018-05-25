package com.example.furkanbaycan.gasstation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.furkanbaycan.gasstation.HTTPParser.ApiInterface;
import com.example.furkanbaycan.gasstation.HTTPParser.BenzinParser;
import com.example.furkanbaycan.gasstation.HTTPParser.DataModel;
import com.example.furkanbaycan.gasstation.HTTPParser.LPGParser;
import com.example.furkanbaycan.gasstation.HTTPParser.MotorinParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import okhttp3.Dispatcher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ListActivity extends BaseActivity implements RecyclerAdapter.ItemClickListener, RecyclerAdapterLPG.ItemClickListener{
    private LinearLayout linearLayout;
    private TextView katkili;
    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private List<DataModel> dataModelArrayList = new ArrayList<DataModel>();
    private String il,ilce,yakit,url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        findViewById();
        getBundle();
        retrofit(url);
    }

    private void findViewById() {
        linearLayout = findViewById(R.id.list_linearLayout);
        katkili = findViewById(R.id.list_fiyat2);
    }

    private void getBundle() {

        Bundle bundle = getIntent().getExtras();

        if (bundle == null){
            il = null;
            ilce = null;
            yakit = null;
        }
        else{
            il = bundle.getString("il");
            ilce = bundle.getString("ilce");
            yakit = bundle.getString("yakit");
            if (yakit.equals("LPG")){
                setTitle(il +" "+ yakit +" Fiyatları");
            }
            else {
                setTitle(il+" "+ilce +" "+ yakit +" Fiyatları");
            }
        }
        il = trToEn(il);
        ilce = trToEn(ilce);
        yakit = yakit.toLowerCase();
        if (yakit.equals("lpg")){
            linearLayout.setWeightSum(2);
            katkili.setVisibility(View.GONE);
            url = "http://lpgal.com/"+il+"-"+yakit+"-fiyatlari/";
        }
        else {
            url = "https://benzinal.com/"+il+"-"+ilce+"-"+yakit+"-fiyatlari/";
        }
    }

    private void retrofit(String url) {
        showProgressDialog();
        Dispatcher dispatcher = new Dispatcher(Executors.newFixedThreadPool(20));
        dispatcher.setMaxRequests(20);
        dispatcher.setMaxRequestsPerHost(1);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url)
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<String> stringCall = apiInterface.getStringResponse("");
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    if(yakit.equals("motorin")){
                        MotorinParser motorinParser = new MotorinParser();
                        dataModelArrayList = motorinParser.getMotorin(responseString);
                    }
                    else if(yakit.equals("benzin")){
                        BenzinParser benzinParser = new BenzinParser();
                        dataModelArrayList = benzinParser.getBenzin(responseString);
                    }
                    else {
                        LPGParser lpgParser = new LPGParser();
                        dataModelArrayList = lpgParser.getLPG(responseString);
                    }

                    hideProgressDialog();
                    recylerView(dataModelArrayList);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void recylerView(List<DataModel> dataModelArrayList) {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (yakit.equals("lpg")){
            RecyclerAdapterLPG adapter = new RecyclerAdapterLPG(dataModelArrayList,this);
            adapter.setItemClickListener(this);
            recyclerView.setAdapter(adapter);
        }
        else {
            RecyclerAdapter adapter = new RecyclerAdapter(dataModelArrayList,this);
            adapter.setItemClickListener(this);
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("dataModel",dataModelArrayList.get(position));
        i.putExtra("il",il);
        i.putExtra("ilce",ilce);
        startActivity(i);

    }
}
