package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends AppCompatActivity {
    public MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        song = MediaPlayer.create(this, R.raw.sonic_select);
        song.start();
    }
    public void openGame_easy (View view){
        stopPlaying();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_medium (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_hard (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_impossible (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openCustom (View view){
        Intent intent = new Intent(this, Custom.class);
        startActivity(intent);
    }
    public void stopPlaying(){
        if (song != null) {
            song.stop();
            song.release();
            song = null;
        }
    }
}
