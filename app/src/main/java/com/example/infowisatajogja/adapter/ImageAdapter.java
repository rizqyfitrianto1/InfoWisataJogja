package com.example.infowisatajogja.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.infowisatajogja.R;

public class ImageAdapter extends BaseAdapter {

    //List Konten Gambar yang akan ditampilkan pada GridView
    public static int[] gambar = {R.drawable.circle_asia, R.drawable.circler_africa, R.drawable.circle_europe,
            R.drawable.circle_america, R.drawable.circle_asia, R.drawable.circler_africa,
            R.drawable.circle_europe, R.drawable.circle_america, R.drawable.circle_asia,
            R.drawable.circler_africa, R.drawable.circle_europe, R.drawable.circle_america};

    private Context mContext;

    //Membuat Contructor, dengan parameter Context, Untuk menghubungkan Adapter dengan GridView
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        //Menghitung Jumlah/Panjang dari Daftar Konten
        return gambar.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    //Membuat ImageView baru untuk setiap item yang direferensikan oleh Adaptor
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        //Jika tidak di daur ulang
        if (convertView == null) {
            //Menginisialisasi beberapa atribut
            imageView = new ImageView( mContext );
            //Mengatur Panjang dan Lebar pada ImageView
            imageView.setLayoutParams( new GridView.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT,300) );
            imageView.setScaleType( ImageView.ScaleType.CENTER_CROP );
            //Mengatur Padding
            imageView.setPadding( 0, 0, 10, 0 );
        } else {
            imageView = (ImageView) convertView;
        }

        //Mengset Image dari Resource/Sumber berdasarkan posisinya
        imageView.setImageResource( gambar[position] );
        return imageView;
    }
}
