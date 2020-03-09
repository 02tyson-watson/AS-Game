package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer song;
    private Button button;
    String music = "8bit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch (music){
            case "Rock":
                song = MediaPlayer.create(this, R.raw.sonic_select_two);
                try{
                    Thread.sleep(3000);
                    song.start();
                    song.isLooping();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            case "8bit":
                song = MediaPlayer.create(this, R.raw.sonic_select);
                try{
                    Thread.sleep(3000);
                    song.start();
                    song.isLooping();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
        }
    }
    public void difficulty_select(View view){
        Intent intent = new Intent(this, Music.class);
        startActivity(intent);
        stopPlaying();
    }
    public void stopPlaying(){
        if (song != null) {
            song.stop();
            song.release();
            song = null;
        }
    }

}