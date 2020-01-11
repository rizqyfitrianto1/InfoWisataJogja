package com.example.infowisatajogja.adapter;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.infowisatajogja.EditActivity;
import com.example.infowisatajogja.R;
import com.example.infowisatajogja.model.Buku;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    List<Buku> mBukuList;

    public RecyclerAdapter(List<Buku> BukuList){
        mBukuList = BukuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buku, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder,final int position) {
        holder.tv_id.setText("id = " + mBukuList.get(position).getId());
        holder.tv_nama.setText("nama = " + mBukuList.get(position).getJudul());
        holder.tv_pengarang.setText("pengarang = " + mBukuList.get(position).getPengarang());
        holder.tv_tahun.setText("tahun_terbit = " + mBukuList.get(position).getTahun());
        holder.tv_isbn.setText("isbn = " + mBukuList.get(position).getIsbn());
        Picasso.get()
                .load("http://172.16.10.66/infowisatajogja/"+mBukuList.get(position).getSampul())
                .resize(200,200)
                .centerCrop()
                .into(holder.img_sampul);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("id", mBukuList.get(position).getId());
                mIntent.putExtra("nama", mBukuList.get(position).getJudul());
                mIntent.putExtra("pengarang", mBukuList.get(position).getPengarang());
                mIntent.putExtra("tahun_terbit", mBukuList.get(position).getTahun());
                mIntent.putExtra("isbn", mBukuList.get(position).getIsbn());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mBukuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_id, tv_nama, tv_pengarang, tv_tahun, tv_isbn;
        public ImageView img_sampul;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = (TextView) itemView.findViewById(R.id.tv_id);
            tv_nama = (TextView) itemView.findViewById(R.id.tv_judul);
            tv_pengarang = (TextView) itemView.findViewById(R.id.tv_pengarang);
            tv_tahun = (TextView) itemView.findViewById(R.id.tv_tahun);
            tv_isbn = (TextView) itemView.findViewById(R.id.tv_isbn);

            img_sampul = (ImageView) itemView.findViewById(R.id.img_sampul);
        }
    }

}