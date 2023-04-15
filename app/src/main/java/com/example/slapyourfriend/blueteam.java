package com.example.slapyourfriend;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class blueteam extends Fragment {

    Button restart;
    ImageView spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_blueteam, container, false);
        restart=v.findViewById(R.id.restart);
        spinner=v.findViewById(R.id.spinner);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360*3,RotateAnimation.RELATIVE_TO_SELF
                ,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f );
        rotateAnimation.setDuration(10000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        spinner.startAnimation(rotateAnimation);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.bonusmelody);
                mp.start();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
       return v;
    }
}