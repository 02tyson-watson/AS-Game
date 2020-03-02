package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends AppCompatActivity {
    public MediaPlayer song;
    public MediaPlayer easy;
    public MediaPlayer medium;
    public MediaPlayer hard;
    public MediaPlayer custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        song = MediaPlayer.create(this, R.raw.sonic_select);
        easy = MediaPlayer.create(this, R.raw.sonic_easy);
        hard = MediaPlayer.create(this, R.raw.sonic_hard);
        custom = MediaPlayer.create(this, R.raw.sonic_custom);
        song.start();
        Intent intent = getIntent();
    }
    public void openGame_easy (View view){
        stopPlaying();
        easy.start();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_medium (View view){
        stopPlaying();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_hard (View view){
        stopPlaying();
        hard.start();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_impossible (View view){
        stopPlaying();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openCustom (View view){
        stopPlaying();
        custom.start();
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
