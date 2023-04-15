package com.example.slapyourfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    final MediaPlayer mp = MediaPlayer.create(splash.this, R.raw.arcaderising);
                    mp.start();
                    Intent intent = new Intent(splash.this,playactivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
    protected void onPause() {
        super.onPause();
        finish();
    }
}