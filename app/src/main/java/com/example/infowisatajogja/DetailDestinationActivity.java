package com.example.infowisatajogja;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.infowisatajogja.adapter.ImageAdapter;

import static com.example.infowisatajogja.R.*;

public class DetailDestinationActivity extends AppCompatActivity {

    LinearLayout expandableView, expandableView2;
    ImageView arrowBtn, arrowBtn2;
    CardView cardView, cardView2;

    TextView price, title, ship, date, visiting;
    ImageView thumbnail;

    protected GridView TampilanGrid;

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( layout.activity_detail_destination );

        expandableView = findViewById( R.id.line_expandable );
        arrowBtn = findViewById( R.id.arrowBtn );
        cardView = findViewById( id.cardView2 );

        arrowBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource( drawable.ic_arrow_up);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource( drawable.ic_arrow_down);
                }
            }
        });

        expandableView2 = findViewById( R.id.line_expandable2 );
        arrowBtn2 = findViewById( R.id.arrowBtn2 );
        cardView2 = findViewById( id.cardView3 );

        arrowBtn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandableView2.setVisibility(View.VISIBLE);
                    arrowBtn2.setBackgroundResource( drawable.ic_arrow_up);
                } else {
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandableView2.setVisibility(View.GONE);
                    arrowBtn2.setBackgroundResource( drawable.ic_arrow_down);
                }
            }
        });


        thumbnail = (ImageView) findViewById( id.img_destination);
        price = (TextView) findViewById(R.id.price);
        title = (TextView) findViewById(R.id.title);
        ship = (TextView) findViewById(R.id.ship);
        date = (TextView) findViewById(R.id.date);
        visiting = (TextView) findViewById(R.id.visiting);

        String mImage = getIntent().getStringExtra( "thumbnail" );
        Glide.with( this )
                .asBitmap()
                .load( mImage )
                .into( thumbnail );

        price.setText( getIntent().getStringExtra( "price" ) );
        title.setText( getIntent().getStringExtra( "title" ) );
        ship.setText( getIntent().getStringExtra( "ship" ) );
        date.setText( getIntent().getStringExtra( "date" ) );
        visiting.setText( getIntent().getStringExtra( "visiting" ) );

        TampilanGrid = findViewById( id.gridview);
        //Mengset/Menerapkan adapter pada GridView
        TampilanGrid.setAdapter(new ImageAdapter(this));

        //Membuat Listener untuk menangani kejadian saat salah satu item di klik
        TampilanGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                Intent nextPage = new Intent(DetailDestinationActivity.this, DetailPhotoActivtiy.class);
                Bundle bundle = new Bundle();
                //Menyimpan nilai dari padameter position kedalah key posisi.
                //Yang akan dikirimkan pada Activiy ViewGambar
                bundle.putInt("posisi", position);
                nextPage.putExtras(bundle);
                startActivity(nextPage);
            }
        });
    }

}
