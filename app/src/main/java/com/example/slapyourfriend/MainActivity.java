package com.example.slapyourfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String[] sectors={"1","2","3","4","5","6","7","8","9","10","11","12"};
    private static final int [] sectorDegree= new int[sectors.length];
    private static final Random random = new Random();
    private int degree =0;
    private boolean isSpinning =false;

    private ImageView wheel;
    Button playbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheel = findViewById(R.id.spinner);
        playbutton = findViewById(R.id.play);
        getdegreesector();
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSpinning){
                    spin();
                    isSpinning=true;
                }
            }
        });
    }
    public void spin(){
        degree =random.nextInt(sectors.length-1);
        RotateAnimation rotateAnimation = new RotateAnimation(0,(360*sectors.length)+sectorDegree[degree],RotateAnimation.RELATIVE_TO_SELF
                ,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f );
        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "YOU GOT "+sectors[sectors.length-(degree+1)]+" ", Toast.LENGTH_SHORT).show();
                isSpinning=false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wheel.startAnimation(rotateAnimation);

    }


    public void getdegreesector(){
        int SectorDegree = 360/sectors.length;
        for (int i=0;i<sectors.length;i++){
            sectorDegree[i]= (i+1)*SectorDegree;
        }
    }
}