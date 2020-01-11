package com.example.infowisatajogja.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.infowisatajogja.DetailDestinationActivity;
import com.example.infowisatajogja.R;
import com.example.infowisatajogja.model.Destinations;

import java.util.ArrayList;

public class RecyclerHorizontalAdapter extends RecyclerView.Adapter<RecyclerHorizontalAdapter.MyViewHolder> {

    private Context ctx;
    private LayoutInflater inflater;
    private ArrayList<Destinations> imageModelArrayList;

    public RecyclerHorizontalAdapter(Context ctx, ArrayList<Destinations> imageModelArrayList){

        this.ctx =ctx;
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( ctx ).inflate( R.layout.destination_card, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

//        holder.thumbnail.setImageResource(imageModelArrayList.get(position).getPhoto());
        holder.price.setText(imageModelArrayList.get(position).getPrice());
        holder.title.setText(imageModelArrayList.get(position).getTitle());
        holder.ship.setText(imageModelArrayList.get(position).getShip());
        holder.date.setText(imageModelArrayList.get(position).getDate());
        holder.visiting.setText(imageModelArrayList.get(position).getVisiting());

        Glide.with( holder.thumbnail.getContext() )
                .load( imageModelArrayList.get( position ).getPhoto() )
                .into( holder.thumbnail );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ctx, DetailDestinationActivity.class );
                intent.putExtra( "thumbnail",imageModelArrayList.get(position).getPhoto());
                intent.putExtra( "price",imageModelArrayList.get(position).getPrice());
                intent.putExtra( "title",imageModelArrayList.get(position).getTitle());
                intent.putExtra( "ship",imageModelArrayList.get(position).getShip());
                intent.putExtra( "date",imageModelArrayList.get(position).getDate());
                intent.putExtra( "visiting",imageModelArrayList.get(position).getVisiting());
                ctx.startActivity( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_card;
        TextView price, title, ship, date, visiting;
        ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_card = (LinearLayout) itemView.findViewById(R.id.item_card);
            price = (TextView) itemView.findViewById(R.id.price);
            title = (TextView) itemView.findViewById(R.id.title);
            ship = (TextView) itemView.findViewById(R.id.ship);
            date = (TextView) itemView.findViewById(R.id.date);
            visiting = (TextView) itemView.findViewById(R.id.visiting);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }

    }
}