package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Music extends AppCompatActivity {
    public static String music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Switch music_switch = (Switch) findViewById(R.id.music_switch);
        music = "8bit";

        music_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    music = "Rock";
                } else {
                    music = "8bit";
                }
            }
        });
    }
    public void back(View view){
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }
}
