package com.example.dice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class twoDicePage extends AppCompatActivity {
    public Button roll;
    public ImageView dice1,fimg1,fimg2,fimg3,fimg4,fimg5,fimg6,simg1,simg2,simg3,simg4,simg5,simg6;
    TextView showCount;
    TextView showValue;
    private RelativeLayout rl;
    int clickcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyMethods twoDiceMethods = new MyMethods();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dice_page);

        SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
        String colour = prefs.getString("Colour", "WHITE");
        rl = (RelativeLayout) findViewById(R.id.RelativeLayoutTDP);
        twoDiceMethods.setBackgroundColour(rl,colour);

        fimg1 = findViewById(R.id.firstresult1Pic);
        fimg2 = findViewById(R.id.firstresult2Pic);
        fimg3 = findViewById(R.id.firstresult3Pic);
        fimg4 = findViewById(R.id.firstresult4Pic);
        fimg5 = findViewById(R.id.firstresult5Pic);
        fimg6 = findViewById(R.id.firstresult6Pic);

        simg1 = findViewById(R.id.secondresult1Pic);
        simg2 = findViewById(R.id.secondresult2Pic);
        simg3 = findViewById(R.id.secondresult3Pic);
        simg4 = findViewById(R.id.secondresult4Pic);
        simg5 = findViewById(R.id.secondresult5Pic);
        simg6 = findViewById(R.id.secondresult6Pic);

        dice1= findViewById(R.id.TwoDice1);

        roll = findViewById(R.id.rollButton);
        final MediaPlayer drSound = MediaPlayer.create(this, R.raw.dicerollsound);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMethods twoDiceMethods = new MyMethods();
                twoDiceMethods.rollAnimationmethod(drSound,dice1);


                int num1 = twoDiceMethods.randomNumberGenerator();
                int num2 = twoDiceMethods.randomNumberGenerator();

                fimg1.setVisibility(View.INVISIBLE);
                fimg2.setVisibility(View.INVISIBLE);
                fimg3.setVisibility(View.INVISIBLE);
                fimg4.setVisibility(View.INVISIBLE);
                fimg5.setVisibility(View.INVISIBLE);
                fimg6.setVisibility(View.INVISIBLE);

                simg1.setVisibility(View.INVISIBLE);
                simg2.setVisibility(View.INVISIBLE);
                simg3.setVisibility(View.INVISIBLE);
                simg4.setVisibility(View.INVISIBLE);
                simg5.setVisibility(View.INVISIBLE);
                simg6.setVisibility(View.INVISIBLE);

                twoDiceMethods.diceVisibility(fimg1,fimg2,fimg3,fimg4,fimg5,fimg6,num1);
                twoDiceMethods.diceVisibility(simg1,simg2,simg3,simg4,simg5,simg6,num2);

                showCount= findViewById(R.id.countBox);
                clickcount = clickcount + 1;
                showCount.setText("Number of Rolls: " + Integer.toString(clickcount));
                showValue= findViewById(R.id.resultText);
                int result = num1+num2;
                showValue.setText("You rolled "+result+"!");
            }
        });

    }
}
