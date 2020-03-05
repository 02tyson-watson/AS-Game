package com.example.asgame;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class ObstacleManager {
    double customFast = Custom.customFast;
    private ArrayList<Obstacle> obstacles;
    private int playerGap;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;
    public double fast = 2;
    public double increase = 0;
    private int score = 0;
    private long startTime;
    String difficulty = Difficulty.difficulty;

    public ObstacleManager(int playerGap, int obstacleGap,int obstacleHeight,int color){
        switch (difficulty){
            case "custom":
                fast = customFast;
            case "impossible":
                increase = 0.00005;
                break;
            case "hard":
                increase = 0.0001;
                break;
            case "medium":
                increase = 0.0005;
                break;
            case "easy":
                increase = 0.0002;
                break;
        }
        this.playerGap=playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = System.currentTimeMillis();
        obstacles = new ArrayList<>();
        populateObstacles();
    }

    public boolean playerCollide(RectPlayer player){
        for(Obstacle ob : obstacles){
            if(ob.playerCollide(player))
                return true;
        }
        return false;
    }
    private void populateObstacles(){
        int currY = -5*Constants.SCREEN_HEIGHT/4;
        while(currY < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight,color,xStart,currY,playerGap));
            currY += obstacleHeight + obstacleGap;
        }
    }
    public void update(){
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = Constants.SCREEN_HEIGHT/10000.0f;
        for(Obstacle ob : obstacles){
            ob.incrementY(speed * elapsedTime * fast);
            fast += increase;
        }
        if(obstacles.get(obstacles.size()-1).getRectangle().top >= Constants.SCREEN_HEIGHT){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight,color, xStart ,obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap,playerGap));
            obstacles.remove(obstacles.size() - 1);
            score++;
        }
    }
    public void draw(Canvas canvas){
        for(Obstacle ob : obstacles)
            ob.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.RED);
        canvas.drawText("Score: " + score, 100,200,paint);

    }
}
