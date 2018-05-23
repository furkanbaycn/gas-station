package com.example.furkanbaycan.gasstation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.furkanbaycan.gasstation.Model.FirebaseSehirModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity  implements View.OnClickListener{
    private TextView ilce_tv;
    private Spinner yakitspinner,sehirspinner,ilceSpinner;
    private Button buton_bul;
    private String il, ilce, yakit = "Benzin";
    private DatabaseReference mDatabase;
    private List<FirebaseSehirModel> firebaseSehirModels = new ArrayList<FirebaseSehirModel>();
    private List<String> sehirler = new ArrayList<String>();
    private List<String> ilceler = new ArrayList<String>();
    private String[] yakit_turu = new String[] {"Benzin", "Motorin", "LPG"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ilIlceCek();
        findViewById();
        setTitle(getString(R.string.secim_yap));
    }

    private void findViewById() {
        ilce_tv = findViewById(R.id.main_ilce_sec);
        yakitspinner = findViewById(R.id.yakitspinner);
        sehirspinner = findViewById(R.id.sehirspinner);
        ilceSpinner = findViewById(R.id.ilceSpinner);
        buton_bul = findViewById(R.id.main_buton_bul);
        buton_bul.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, yakit_turu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yakitspinner.setAdapter(adapter);
    }

    private void ilIlceCek() {
        showProgressDialog();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("sehirler");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    firebaseSehirModels.add(dataSnapshot1.getValue(FirebaseSehirModel.class));
                }
                hideProgressDialog();
                verileriYerlestir();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void verileriYerlestir() {
        for (FirebaseSehirModel firebase:firebaseSehirModels) {
            sehirler.add(firebase.getIl());
        }
        ArrayAdapter<String> sehirAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, sehirler);
        sehirspinner.setAdapter(sehirAdapter);

        sehirspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int Position, long id) {
                il = adapterView.getItemAtPosition(Position).toString();
                for (FirebaseSehirModel firebase:firebaseSehirModels) {
                    if (firebase.getIl().equals(adapterView.getItemAtPosition(Position))){
                        ilceler = firebase.getIlceleri();
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_1, ilceler);
                        ilceSpinner.setAdapter(adapter);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ilceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int Position, long id) {
                ilce=  adapterView.getItemAtPosition(Position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        yakitspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int Position, long id) {
                yakit =  yakitspinner.getSelectedItem().toString();
                if (yakit.equals("LPG")){
                    ilce_tv.setVisibility(View.GONE);
                    ilceSpinner.setVisibility(View.GONE);
                }
                else {
                    ilce_tv.setVisibility(View.VISIBLE);
                    ilceSpinner.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        switch (i) {
            case R.id.main_buton_bul:
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                if (!il.isEmpty() || !ilce.isEmpty() || !yakit.isEmpty()){
                    intent.putExtra("il",il);
                    intent.putExtra("ilce",ilce);
                    intent.putExtra("yakit",yakit);
                }
                startActivity(intent);
                break;
        }
    }
}
