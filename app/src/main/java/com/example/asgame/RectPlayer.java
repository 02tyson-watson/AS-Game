package com.example.asgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class RectPlayer implements GameObject {
    private Rect rectangle;
    private int color;
    public RectPlayer(Rect rectangle,int color){
        this.rectangle = rectangle;
        this.color = color;
    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }
    @Override
    public void update() {

    }
}
