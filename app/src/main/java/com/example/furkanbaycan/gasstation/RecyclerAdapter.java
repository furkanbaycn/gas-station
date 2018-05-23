package com.example.furkanbaycan.gasstation;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.furkanbaycan.gasstation.HTTPParser.DataModel;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public TextView fiyat1,fiyat2;
    public ImageView marka;
    private ItemClickListener itemClickListener;

    @SuppressLint("CutPasteId")
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        fiyat1 = itemView.findViewById(R.id.recycler_fiyat);
        fiyat2 = itemView.findViewById(R.id.recycler_fiyat2);
        marka = itemView.findViewById(R.id.recyler_imageView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);


    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),true);
        return true;
    }
}

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<DataModel> listData = new ArrayList<DataModel>();
    private Context context;

    public RecyclerAdapter(List<DataModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item_recycler_view,parent,false);

        return new RecyclerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.fiyat1.setText(listData.get(position).getPetrolFiyat());
        holder.fiyat2.setText(listData.get(position).getPetrolFiyat2());
        checkImage(holder,position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    Toast.makeText(context, "Uzun Basıldı : "+ listData.get(position), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, " "+ listData.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkImage(RecyclerViewHolder holder,int position) {
        switch (listData.get(position).getPetrolMarka()){
            case "Opet":
                holder.marka.setImageResource(R.drawable.opet);
                break;
            case "M Oil":
                holder.marka.setImageResource(R.drawable.moil);
                break;
            case "Shell":
                holder.marka.setImageResource(R.drawable.shell);
                break;
            case "Total":
                holder.marka.setImageResource(R.drawable.total);
                break;
            case "Petrol Ofisi":
                holder.marka.setImageResource(R.drawable.po);
                break;
            case "Alpet":
                holder.marka.setImageResource(R.drawable.alpet);
                break;
            case "Lukoil":
                holder.marka.setImageResource(R.drawable.lukoil);
                break;
            case "BP":
                holder.marka.setImageResource(R.drawable.bp);
                break;
            case "Aygaz":
                holder.marka.setImageResource(R.drawable.aygaz);
                break;
            case "Mogaz":
                holder.marka.setImageResource(R.drawable.mogaz);
                break;
            case "Aytemiz":
                holder.marka.setImageResource(R.drawable.aytemiz);
                break;
            case "İpragaz":
                holder.marka.setImageResource(R.drawable.ipragaz);
                break;
            case "Milangaz":
                holder.marka.setImageResource(R.drawable.milangaz);
                break;
            case "Akpet":
                holder.marka.setImageResource(R.drawable.akpet);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
