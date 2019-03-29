package com.example.dice;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static java.lang.Thread.sleep;


public class MyMethods {

    public static int randomNumberGenerator() {
        int random = (int) (Math.random() * 6 + 1);
        return random;
    }

    public void rollAnimationmethod(MediaPlayer mediaPlayer, ImageView imageView) {

        int animationDuration = 600;
        //What i want the animation to do and how long it should be
        ObjectAnimator rotaionAnimation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        rotaionAnimation.setDuration(animationDuration);
        //To play the animation
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotaionAnimation);
        animatorSet.start();
        mediaPlayer.start();
    }

    //This is for to make the dice result visible when a random number is generated
    public void diceVisibility(ImageView img1, ImageView img2, ImageView img3, ImageView img4, ImageView img5, ImageView img6, int num) {

        if (num == 1) {
            img1.setVisibility(View.VISIBLE);
        } else if (num == 2) {
            img2.setVisibility(View.VISIBLE);
        } else if (num == 3) {
            img3.setVisibility(View.VISIBLE);
        } else if (num == 4) {
            img4.setVisibility(View.VISIBLE);
        } else if (num == 5) {
            img5.setVisibility(View.VISIBLE);
        } else {
            img6.setVisibility(View.VISIBLE);
        }

    }

    public static String getBackgroundColour(int id) {
        if (id == 1) {
            return "Red";
        } else if (id == 2) {
            return "Yellow";
        } else if (id == 3) {
            return "Blue";
        } else
            return "White";
    }
    public void setBackgroundColour(RelativeLayout rl, String colour) {
        if(colour.equals("Red")){
            rl.setBackgroundResource(R.color.Red);
        }
        else if(colour.equals("Yellow")){
            rl.setBackgroundResource(R.color.Yellow);
        }
        else if(colour.equals("Blue")){
            rl.setBackgroundResource(R.color.Blue);
        }
        else{
            rl.setBackgroundResource(R.color.White);
    }
    }

}