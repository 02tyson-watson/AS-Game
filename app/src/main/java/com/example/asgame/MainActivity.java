package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer sonicx = MediaPlayer.create(this, R.raw.sonic_x);
        sonicx.start();
        sonicx.isLooping();
    }public void difficulty_select(View view){
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }
}
