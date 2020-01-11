package com.example.infowisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;

public class Splashscreen extends AppCompatActivity {

    ImageView img_logo;
    TextView text_logo, slogan_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        img_logo = (ImageView) findViewById(R.id.logo);
        text_logo = (TextView) findViewById(R.id.text_logo);
        slogan_logo = (TextView) findViewById(R.id.slogan);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        img_logo.startAnimation(myanim);
        final Intent intent = new Intent(Splashscreen.this, Walktrough.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }catch (    InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
