package com.example.slapyourfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String[] sectors={"1","2","3","4","5","6","7","8","9","10","11","12"};
    private static final int [] sectorDegree= new int[sectors.length];
    private static final Random random = new Random();
    private int degree =0;
    private boolean isSpinning =false;

    private ImageView wheel;
    int spinnumber;
    Button playbutton,resetnumberpf1;


    // Player 1
    TextView  textviewpf1 ,textviewps1,redteamp1;
    ImageView redteamplus1;
    int redteampoint=0;
    RadioGroup radioGroupp1;
    final int[] pf1 = new int[1];
    final int[] ps1 = new int[1];
    int ppf1,pps1;
    RadioButton radioButtonpp1,radio_buttonpf1,radio_buttonps1;
    int checkedIdp1;
    //Player2
    Button resetnumberpf2;
    ImageView blueteamplus1;
    final int[] pf2 = new int[1];
    final int[] ps2 = new int[1];
    int ppf2,pps2;
    int blueteampoint=0;
    TextView textviewpf2,textviewps2,blueteamp2;
    RadioGroup radioGroupp2;
    RadioButton radioButtonpp2,radio_buttonpf2,radio_buttonps2;
    int checkedIdp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheel = findViewById(R.id.spinner);
        playbutton = findViewById(R.id.play);
        redteamplus1=findViewById(R.id.redteamplus1);
        redteamplus1.setVisibility(View.INVISIBLE);
        blueteamplus1=findViewById(R.id.blueteamplus1);
        blueteamplus1.setVisibility(View.INVISIBLE);
        getdegreesector();
        //player 1 rest number button start
        resetnumberpf1= (Button) findViewById(R.id.resetnumberpf1);
        textviewpf1=findViewById(R.id.textviewpf1);
        textviewps1=findViewById(R.id.textviewps1);
        int j=12;
        pf1[0]=random.nextInt(j);
        ppf1=pf1[0];
        ps1[0]=random.nextInt(j);
        pps1=ps1[0];
        textviewpf1.setText(String.valueOf(ppf1));
        textviewps1.setText(String.valueOf(pps1));
        resetnumberpf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pf1[0] =random.nextInt(j);
                ppf1=pf1[0];
                ps1[0] =random.nextInt(j);
                pps1=ps1[0];
                textviewpf1.setText(String.valueOf(ppf1));
                textviewps1.setText(String.valueOf(pps1));
                final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gameclick);
                mp.start();
            }
        });
        //player 1 rest number button End

        //player 2 rest number button start
        resetnumberpf2= (Button) findViewById(R.id.resetnumberpf2);
        textviewpf2=findViewById(R.id.textviewpf2);
        textviewps2=findViewById(R.id.textviewps2);
        pf2[0]=random.nextInt(j);
        ppf2=pf2[0];
        ps2[0]=random.nextInt(j);
        pps2=ps2[0];
        textviewpf2.setText(String.valueOf(ppf2));
        textviewps2.setText(String.valueOf(pps2));
        resetnumberpf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pf2[0] =random.nextInt(j);
                ppf2=pf2[0];
                ps2[0] =random.nextInt(j);
                pps2=ps2[0];
                textviewpf2.setText(String.valueOf(ppf2));
                textviewps2.setText(String.valueOf(pps2));
                final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gameclick);
                mp.start();
            }
        });
        //player 1 rest number button start


        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroupp1 = findViewById(R.id.radiogroupp1);
                checkedIdp1 = radioGroupp1.getCheckedRadioButtonId();
                radioGroupp2 = findViewById(R.id.radiogroupp2);
                checkedIdp2 = radioGroupp2.getCheckedRadioButtonId();
                if(checkedIdp1==-1){
                    Toast.makeText(MainActivity.this, "Red team select any number", Toast.LENGTH_SHORT).show();
                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.clickerror);
                    mp.start();
                }
                else if(checkedIdp2==-1){
                    Toast.makeText(MainActivity.this, "Blue team select any number", Toast.LENGTH_SHORT).show();
                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.clickerror);
                    mp.start();
                }
                else {
                    if (!isSpinning) {
                        final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gameclick);
                        mp.start();
                        spin();
                        isSpinning = true;

                    }
                }

            }
        });


    }
    public void spin() {
            resetnumberpf1.setEnabled(false);
            resetnumberpf2.setEnabled(false);
            degree = random.nextInt(sectors.length - 1);
            RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegree[degree], RotateAnimation.RELATIVE_TO_SELF
                    , 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(3600);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gamespin);
                        mp.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        spinnumber= Integer.parseInt(sectors[sectors.length - (degree + 1)]);
                        Toast.makeText(MainActivity.this, "Number " + spinnumber + " ", Toast.LENGTH_SHORT).show();
                        isSpinning = false;
                        AlphaAnimation fadeInAnimation = new AlphaAnimation(1.0f, 0.0f);
                        fadeInAnimation.setDuration(2000);
                        //Player 1
                        radioButtonpp1 = (RadioButton) findViewById(checkedIdp1);
                        radio_buttonpf1=findViewById(R.id.radio_buttonpf1);
                        radio_buttonps1=findViewById(R.id.radio_buttonps1);
                        redteamp1=findViewById(R.id.redteamp1);
                            if (radio_buttonpf1==radioButtonpp1) {
                                if (spinnumber == ppf1) {
                                    redteampoint += 1;
                                    fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                            redteamplus1.setVisibility(View.VISIBLE);
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            // Set the visibility of the ImageView to VISIBLE when the animation ends
                                            redteamplus1.setVisibility(View.INVISIBLE);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {}
                                    });
                                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.smallwin1);
                                    mp.start();
                                    redteamplus1.startAnimation(fadeInAnimation);
                                    //Checking for Total points
                                }
                                // end of if condition
                            } else if (radio_buttonps1==radioButtonpp1) {
                                if (spinnumber == pps1) {
                                    redteampoint += 1;
                                    fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                            redteamplus1.setVisibility(View.VISIBLE);
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            // Set the visibility of the ImageView to VISIBLE when the animation ends
                                            redteamplus1.setVisibility(View.INVISIBLE);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {}
                                    });
                                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.smallwin1);
                                    mp.start();
                                    redteamplus1.startAnimation(fadeInAnimation);


                                }
                            } //end of else conditon player1

                        // Display of red points
                        redteamp1.setText(String.valueOf(redteampoint));

                        //player 2
                        radioButtonpp2 = (RadioButton) findViewById(checkedIdp2);
                        radio_buttonpf2=findViewById(R.id.radio_buttonpf2);
                        radio_buttonps2=findViewById(R.id.radio_buttonps2);
                        blueteamp2=findViewById(R.id.blueteamp2);
                            if (radio_buttonpf2==radioButtonpp2) {
                                if (spinnumber == ppf2) {
                                    blueteampoint += 1;
                                    fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                            blueteamplus1.setVisibility(View.VISIBLE);
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            // Set the visibility of the ImageView to VISIBLE when the animation ends
                                            blueteamplus1.setVisibility(View.INVISIBLE);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {}
                                    });
                                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.smallwin2);
                                    mp.start();
                                    blueteamplus1.startAnimation(fadeInAnimation);
                                }
                            } else if (radio_buttonps2==radioButtonpp2) {
                                if (spinnumber == pps2) {
                                    blueteampoint += 1;
                                    fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                            blueteamplus1.setVisibility(View.VISIBLE);
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            // Set the visibility of the ImageView to VISIBLE when the animation ends
                                            blueteamplus1.setVisibility(View.INVISIBLE);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {}
                                    });
                                    final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.smallwin2);
                                    mp.start();
                                    blueteamplus1.startAnimation(fadeInAnimation);
                                }
                            }
                            // Display of blue team points
                            blueteamp2.setText(String.valueOf(blueteampoint));
                            //win or lose check
                        // Enable thr button
                        resetnumberpf1.setEnabled(true);
                        resetnumberpf2.setEnabled(true);
                        if(redteampoint==2){
                            Toast.makeText(MainActivity.this, "Red team", Toast.LENGTH_SHORT).show();
                            Fragment fragment =new winfragment();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,fragment).commit();
                            final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.casinoreward);
                            mp.start();
                            playbutton.setVisibility(View.GONE);
                            resetnumberpf1.setVisibility(View.GONE);
                            resetnumberpf2.setVisibility(View.GONE);
                            radioGroupp1.setVisibility(View.GONE);
                            radioGroupp2.setVisibility(View.GONE);

                        }
                        if(blueteampoint==2){
                            Toast.makeText(MainActivity.this, "Blue team", Toast.LENGTH_SHORT).show();
                            Fragment fragment =new blueteam();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container,fragment).commit();
                            final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.casinoreward);
                            mp.start();
                            playbutton.setVisibility(View.GONE);
                            resetnumberpf2.setVisibility(View.GONE);
                            resetnumberpf1.setVisibility(View.GONE);
                            radioGroupp1.setVisibility(View.GONE);
                            radioGroupp2.setVisibility(View.GONE);
                        }
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