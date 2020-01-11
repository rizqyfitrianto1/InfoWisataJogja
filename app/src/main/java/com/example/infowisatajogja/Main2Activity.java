package com.example.infowisatajogja;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.infowisatajogja.adapter.RecyclerHorizontalAdapter;
import com.example.infowisatajogja.model.Destinations;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    private RecyclerView myrecyclerview;
        private ArrayList<Destinations> mData;
    private RecyclerHorizontalAdapter adapter;

    ViewFlipper v_flipper;
    @Nullable
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int images[] = {R.drawable.slider5, R.drawable.slider2, R.drawable.slider4};
        v_flipper = (ViewFlipper)findViewById(R.id.v_flipper);

        for (int image: images){
            flipperImages(image);
        }

        myrecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        myrecyclerview.setHasFixedSize(true);
        mData = dataCard();
        adapter = new RecyclerHorizontalAdapter(this,mData);
        myrecyclerview.setAdapter(adapter);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false ));


    }


    private ArrayList<Destinations> dataCard() {
        ArrayList<Destinations> mData = new ArrayList<>(  );
        mData.add( new Destinations( "Rp 10.000.000", "Royal Bahamas" ,"3 NIGHT", "Date : 17/12/2019", "Visiting : Fort Laudardale, Nassau, Cruising", "https://images.cruisecritic.com/image/308/how-to-find-the-best-cruise-bargains-in-2019_600x400_21.jpg") );
        mData.add( new Destinations( "Rp 11.000.000", "Royal Bahamas" ,"4 NIGHT", "Date : 18/12/2019", "Visiting : Fort Laudardale, Nassau, Cruising", "https://s.marketwatch.com/public/resources/images/MW-FL354_cruise_ZH_20170427163151.jpg") );
        mData.add( new Destinations( "Rp 12.000.000", "Royal Bahamas" ,"5 NIGHT", "Date : 19/12/2019", "Visiting : Fort Laudardale, Nassau, Cruising", "https://images.r.cruisecritic.com/features/ships/top-25-tips/passport-for-cruise-2.jpg") );
        mData.add( new Destinations( "Rp 13.000.000", "Royal Bahamas" ,"6 NIGHT", "Date : 20/12/2019", "Visiting : Fort Laudardale, Nassau, Cruising", "https://i.cbc.ca/1.5163014.1559744139!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/cuba-usa-trade.jpg") );
        mData.add( new Destinations( "Rp 14.000.000", "Royal Bahamas" ,"7 NIGHT", "Date : 21/12/2019", "Visiting : Fort Laudardale, Nassau, Cruising", "https://images.r.cruisecritic.com/news/2018/05/news-carnival-sunshine-cuba.jpg") );
        return mData;
    }


    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }


}
