package com.example.slapyourfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class playactivity extends AppCompatActivity {
    ImageView start;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);
        start = findViewById(R.id.start);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF
                ,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f );
        rotateAnimation.setDuration(6000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        start.startAnimation(rotateAnimation);
        play = findViewById(R.id.playbtn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(playactivity.this,MainActivity.class);
                startActivity(intent);
                RotateAnimation rotateAnimation = new RotateAnimation(0,360*3,RotateAnimation.RELATIVE_TO_SELF
                        ,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f );
                rotateAnimation.setDuration(3600);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                start.startAnimation(rotateAnimation);
            }
        });
    }
}