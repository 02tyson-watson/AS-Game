package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
    }
    public void openGame_easy (View view){
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
}
