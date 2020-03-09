package com.example.asgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Custom extends AppCompatActivity {
    public static int customObGap;
    public static int playerColorNumber;
    public static int obstacleColorNumber;
    public static int backgroundColorNumber;
    String difficulty = Difficulty.difficulty;
    public static int customGap;
    public static double customFast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }
    public void openGamecustom (View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
        difficulty = "custom";
    }public void obgapup(View view){
        customObGap++;
        displayobgap(customObGap);
    }public void obgapdown (View view){
        customObGap--;
        displayobgap(customObGap);
    }public void gapup (View view){
        customGap++;
        displaygap(customGap);
    }public void gapdown (View view){
        customGap--;
        displaygap(customGap);
    }public void fastup (View view){
        customFast++;
        displayfast(customFast);
    }public void fastdown (View view){
        customFast--;
        displayfast(customFast);
    }public void pRed (View view){
        playerColorNumber = 1;
    }public void pGreen(View view){
        playerColorNumber = 2;
    }public void pBlue(View view){
        playerColorNumber = 3;
    }public void obWhite(View view){
        obstacleColorNumber = 1;
    }public void obRed(View view){
        obstacleColorNumber = 2;
    }public void obBlue(View view){
        obstacleColorNumber = 3;
    }public void blackBack(View view){
        backgroundColorNumber = 1;
    }public void backWhite(View view){
        backgroundColorNumber = 2;
    }private void displayobgap(int number){
        TextView obgapnumber = findViewById(R.id.obgapnumber);
        obgapnumber.setText("" + number);
    }private void displaygap(int number){
        TextView gapnumber = findViewById(R.id.gapnumber);
        gapnumber.setText("" + number);
    }private void displayfast(double number){
        TextView fastnumber = findViewById(R.id.fastnumber);
        fastnumber.setText("" + number);
    }
}
