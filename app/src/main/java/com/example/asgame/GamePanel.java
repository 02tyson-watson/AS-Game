package com.example.asgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static com.example.asgame.MainThread.canvas;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    String difficulty = Difficulty.difficulty;
    int customObGap = Custom.customObGap;
    int customGap = Custom.customGap;
    public static int score = 0;
    private Rect r = new Rect();
    private MainThread thread;
    private RectPlayer player;
    private Point playerPoint;
    private ObstacleManager obstacleManager;
    private boolean movingPlayer = false;
    public static boolean gameOver = false;
    private long gameOverTime;
    public int gap = 300;
    public int obGap = 500;
    public int height = 100;

    public GamePanel (Context context){
        super(context);
        if(customGap > -1){
            customGap *= 100;
        }

        if(customObGap > -1){
            customObGap*= 100;
        }
        switch (difficulty){
            case "custom":
                gap = customGap;
                obGap = customObGap;
                break;
            case "impossible":
                gap = 300;
                obGap = 200;
                break;
            case "hard":
                gap = 400;
                obGap = 300;
                break;
            case "easy":
                gap = 800;
                obGap = 500;
                break;
            case "medium":
                gap = 600;
                obGap = 500;
                break;
        }

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        player = new RectPlayer(new Rect( 100,200,200,100),Color.BLUE);
        playerPoint = new Point(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT - 200);
        player.update(playerPoint);
        obstacleManager= new ObstacleManager(gap, obGap, height, Color.WHITE );

        // playerGap is how big the whole is for the player to fit into
        // ObstacleGap is the gap between the different bars
        // height is just how thick the bars are
        setFocusable(true);
    }
    public void reset(){

        playerPoint = new Point(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT - 200);
        player.update(playerPoint);
        obstacleManager= new ObstacleManager(gap, obGap, height, Color.WHITE );
        movingPlayer = false;
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while (true){
            try {
                thread.setRunning(false);
                thread.join();

            } catch(Exception e) {e.printStackTrace();}
            retry = false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                if(!gameOver && player.getRectangle().contains((int)event.getX(), (int)event.getY())){
                    movingPlayer = true;
                break;
                }if(gameOver && System.currentTimeMillis() - gameOverTime >= 1000){
                reset();
                gameOver = false;
                break;
                }
            case MotionEvent.ACTION_MOVE:
                if(!gameOver && !movingPlayer){
                    playerPoint.set((int)event.getX(), (int)event.getY());
                }break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                break;
        }
        return true;
    }
    public void update(){
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.RED);
        drawTopText(canvas, paint, score);
        if(!gameOver) {
            player.update(playerPoint);
            obstacleManager.update();
            if(obstacleManager.playerCollide(player)){
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }
        }
    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.BLACK);
        player.draw(canvas);
        obstacleManager.draw(canvas);
        if(gameOver){
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.RED);
            drawCenterText(canvas, paint, "Game Over.");

        }
    }
    private void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

    private void drawTopText(Canvas canvas,Paint paint,int points){
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Score: " + points,  5,25, paint);
    }
}
