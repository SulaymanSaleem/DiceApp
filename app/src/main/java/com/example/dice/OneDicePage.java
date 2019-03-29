package com.example.dice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class OneDicePage extends AppCompatActivity {
    public Button roll;
    public ImageView dice1,img1,img2,img3,img4,img5,img6;
    TextView showCount;
    TextView showValue;
    private RelativeLayout rl;
    int clickcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyMethods oneDiceMethods = new MyMethods();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_dice_page);

        SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
        String colour = prefs.getString("Colour", "WHITE");
        rl = (RelativeLayout) findViewById(R.id.RelativeLayoutODP);
        oneDiceMethods.setBackgroundColour(rl,colour);

        img1 = findViewById(R.id.result1Pic);
        img2 = findViewById(R.id.result2Pic);
        img3 = findViewById(R.id.result3Pic);
        img4 = findViewById(R.id.result4Pic);
        img5 = findViewById(R.id.result5Pic);
        img6 = findViewById(R.id.result6Pic);
        roll = findViewById(R.id.rollButton);
        dice1= findViewById(R.id.OneDice1);
        showCount= findViewById(R.id.countBox);
        showValue= findViewById(R.id.resultText);
        final MediaPlayer drSound = MediaPlayer.create(this, R.raw.dicerollsound);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMethods oneDiceMethods = new MyMethods();

                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);

                int num = oneDiceMethods.randomNumberGenerator();

                oneDiceMethods.rollAnimationmethod(drSound,dice1);

                    oneDiceMethods.diceVisibility(img1,img2,img3,img4,img5,img6,num);

                    clickcount = clickcount + 1;
                    showCount.setText("Number of Rolls: " + Integer.toString(clickcount));
                    showValue.setText("You rolled a "+ num + "!");
                }


        });

    }


}
