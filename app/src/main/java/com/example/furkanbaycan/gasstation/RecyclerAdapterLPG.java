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


public class RecyclerAdapterLPG extends RecyclerView.Adapter<RecyclerAdapterLPG.RecyclerViewHolderLPG>{
    public RecyclerAdapterLPG.ItemClickListener itemClickListener;
    private List<DataModel> listData = new ArrayList<DataModel>();
    private Context context;

    public RecyclerAdapterLPG(List<DataModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public RecyclerViewHolderLPG onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item_recycler_lpg,parent,false);

        return new RecyclerViewHolderLPG(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderLPG holder, int position) {
        holder.fiyat1.setText(listData.get(position).getPetrolFiyat());
        checkImage(holder,position);
    }

    class RecyclerViewHolderLPG extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView fiyat1;
        public ImageView marka;

        @SuppressLint("CutPasteId")
        public RecyclerViewHolderLPG(View itemView) {
            super(itemView);
            fiyat1 = itemView.findViewById(R.id.recycler_lpg_fiyat);
            marka = itemView.findViewById(R.id.recyler_lpg_imageView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if(view == itemView){
                if(itemClickListener != null) itemClickListener.onClick(view,getAdapterPosition(),false);
            }


        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),true);
            return true;
        }
    }

    private void checkImage(RecyclerViewHolderLPG holder,int position) {
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

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}
