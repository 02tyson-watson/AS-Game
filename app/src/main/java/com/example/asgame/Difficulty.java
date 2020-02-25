package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

    }
    public void openGame_easy (View view){
        final MediaPlayer select = MediaPlayer.create(this, R.raw.sonic_select);
        final MediaPlayer easy = MediaPlayer.create(this, R.raw.sonic_easy);
        try{
            select.pause();
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        easy.start();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_medium (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_hard (View view){
        final MediaPlayer select = MediaPlayer.create(this, R.raw.sonic_select);
        final MediaPlayer hard = MediaPlayer.create(this, R.raw.sonic_hard);
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        select.stop();
        hard.start();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openGame_impossible (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void openCustom (View view){
        final MediaPlayer select = MediaPlayer.create(this, R.raw.sonic_select);
        final MediaPlayer custom = MediaPlayer.create(this, R.raw.sonic_custom);
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        select.stop();
        custom.start();
        Intent intent = new Intent(this, Custom.class);
        startActivity(intent);
    }
}
