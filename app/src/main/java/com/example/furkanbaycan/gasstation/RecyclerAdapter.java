package com.example.furkanbaycan.gasstation;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private ItemClickListener itemClickListener;
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

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView fiyat1,fiyat2;
        public ImageView marka;

        @SuppressLint("CutPasteId")
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            fiyat1 = itemView.findViewById(R.id.recycler_fiyat);
            fiyat2 = itemView.findViewById(R.id.recycler_fiyat2);
            marka = itemView.findViewById(R.id.recyler_imageView);
            itemView.setOnClickListener(this);


        }
        @Override
        public void onClick(View view) {
            if (view == itemView){
                if(itemClickListener != null) itemClickListener.onClick(view,getAdapterPosition(),false);
            }


        }

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }
}

