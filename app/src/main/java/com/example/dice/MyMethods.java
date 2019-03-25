package com.example.dice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;


public class MyMethods {

    public static int randomNumberGenerator(){
        int random = (int)(Math.random() * 6 + 1);
        return random;
    }
    public void rollAnimationmethod(MediaPlayer mediaPlayer, ImageView imageView){
        int animationDuration = 600;
        mediaPlayer.start();
        ObjectAnimator rotaionAnimation= ObjectAnimator.ofFloat(imageView,"rotation",0f, 360f);
        rotaionAnimation.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotaionAnimation);
        animatorSet.start();
    }
    //This is for to make the dice result visible when a random number is generated
    public void diceVisibility(ImageView img1,ImageView img2,ImageView img3,ImageView img4,ImageView img5, ImageView img6,int num){
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

    public void setBackgroundColour(View view, int id){
        if (id==1) {
            view.setBackgroundResource(R.color.Red);
        }
        else if (id==2){
            view.setBackgroundResource(R.color.Yellow);
        }
        else if (id==3){
            view.setBackgroundResource(R.color.Blue);
        }
        else {
            view.setBackgroundResource(R.color.White);
        }
    }
}

