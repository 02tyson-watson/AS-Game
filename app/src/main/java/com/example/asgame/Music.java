package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Music extends AppCompatActivity {
    Switch music_switch = (Switch) findViewById(R.id.music_switch);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Switch music_switch = (Switch) findViewById(R.id.music_switch);
        music_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
