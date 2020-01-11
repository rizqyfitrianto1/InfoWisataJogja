package com.example.infowisatajogja;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.infowisatajogja.adapter.ImageAdapter;

public class DetailPhotoActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_photo);

        int imgPosition = this.getIntent().getExtras().getInt("posisi");
        ImageView iv = findViewById(R.id.detail_photo);

        int getImage = ImageAdapter.gambar[imgPosition];
        iv.setImageResource(getImage);
    }
}
