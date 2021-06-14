package com.example.appnhac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder>{
    Context context;
    ArrayList<list_baihat> BaihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<list_baihat> baihatArrayList) {
        this.context = context;
        BaihatArrayList = baihatArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( BaihathotAdapter.ViewHolder holder, int position) {
        list_baihat list_baihat = BaihatArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtcasi;
        ImageView imghinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.ten_bai_hat);
            txtcasi = itemView.findViewById(R.id.sum_time);
            imghinh = itemView.findViewById(R.id.imageviewbaihathot);

        }
    }
}
