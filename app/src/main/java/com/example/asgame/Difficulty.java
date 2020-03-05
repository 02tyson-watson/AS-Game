package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {
    public MediaPlayer song;
    public MediaPlayer easy;
    public MediaPlayer medium;
    public MediaPlayer hard;
    public MediaPlayer impossible;
    public MediaPlayer custom;
    public static String difficulty;
    String music = Music.music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        stopPlaying();
        song = MediaPlayer.create(this, R.raw.sonic_select);
        easy = MediaPlayer.create(this, R.raw.sonic_easy);
        medium = MediaPlayer.create(this, R.raw.sonic_medium);
        hard = MediaPlayer.create(this, R.raw.sonic_hard);
        impossible = MediaPlayer.create(this, R.raw.sonic_impossible);
        switch (music){
            case "8bit":
                stopPlaying();
                song = MediaPlayer.create(this, R.raw.sonic_select);
                easy = MediaPlayer.create(this, R.raw.sonic_easy);
                medium = MediaPlayer.create(this, R.raw.sonic_medium);
                hard = MediaPlayer.create(this, R.raw.sonic_hard);
                impossible = MediaPlayer.create(this, R.raw.sonic_impossible);
                break;
            case "Rock":
                stopPlaying();
                song = MediaPlayer.create(this, R.raw.sonic_select_two);
                easy = MediaPlayer.create(this, R.raw.sonic_easy_two);
                medium = MediaPlayer.create(this, R.raw.sonic_medium_two);
                hard = MediaPlayer.create(this, R.raw.sonic_hard_two);
                impossible = MediaPlayer.create(this, R.raw.sonic_impossible_two);
                break;

        }

        song.start();
        Intent intent = getIntent();
    }
    public void openGame_easy (View view){
        stopPlaying();
        easy.start();
        difficulty = "easy";
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_medium (View view){
        stopPlaying();
        medium.start();
        difficulty = "medium";
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }
    public void openGame_hard (View view){
        stopPlaying();
        hard.start();
        difficulty = "hard";
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_impossible (View view){
        stopPlaying();
        impossible.start();
        difficulty = "impossible";
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openCustom (View view){
        stopPlaying();
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
