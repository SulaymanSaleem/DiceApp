package com.example.dice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout rl;
    private Button oneDiceButton;
    private Button twoDiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyMethods mainActivityMethods = new MyMethods();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
        String colour = prefs.getString("Colour", "WHITE");
        rl = (RelativeLayout) findViewById(R.id.RelativeLayoutMain);
        mainActivityMethods.setBackgroundColour(rl,colour);

        oneDiceButton = findViewById(R.id.OneDiceButton);
        oneDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneDicePage();
            }
        });
         twoDiceButton = findViewById(R.id.TwoDiceButton);
         twoDiceButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openTwoDicePage();
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:
                openSettingsPage();
                break;
            case R.id.update:
                Toast.makeText(getApplicationContext(),"Latest Version Installed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                openHelpPage();
                break;
            default:
                //unknown error
        }
        return super.onOptionsItemSelected(item);
    }

    public void openOneDicePage(){
        Intent intent = new Intent(this, OneDicePage.class);
        startActivity(intent);
    }
    public void openTwoDicePage(){
        Intent intent = new Intent(this,twoDicePage.class);
        startActivity(intent);
    }
    public void openSettingsPage(){
        Intent settings = new Intent(this,SettingsActivity.class);
        startActivity(settings);
    }
    public void openHelpPage(){
        Intent help = new Intent(this,help.class);
        startActivity(help);
    }

}
