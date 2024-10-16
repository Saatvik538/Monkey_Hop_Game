package com.example.lab_08_saatvik;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawView extends View {
    Bitmap monkeyBMP;
    Bitmap bananaBMP;
    private Paint p = new Paint();
    Rect r ;
    Rect r2;
    int count = 0;
    boolean isJumping=false;
    int jumpSpeed =-10, jumpCount=50;
    int bananax = 0;
    int bananax2 = 0;
    int bx2 = 10, bx = 10;
    public int x=0, dx = 15, x2 = 0, dx2 = -15, height1 = 0, height2 = 0;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        monkeyBMP = BitmapFactory.decodeResource(getResources(),R.drawable.monkey);
        bananaBMP = BitmapFactory.decodeResource(getResources(), R.drawable.banana2);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        height1 = (int) (getHeight()*0.6);
        height2 = (int) (getHeight()*0.8);
        r = new Rect((int) (getWidth()*0.3),height1, (int)(getWidth()*0.6),height2);
        bananax2 = (int) (getWidth()*0.1);
        r2 = new Rect(bananax,(int) (getHeight()*0.5), bananax2, (int) (getHeight()*0.55));
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.GREEN);
        canvas.drawRect(0f, getHeight()*0.8f, getWidth(), getHeight(), p);
        p.setColor(Color.CYAN);
        canvas.drawRect(0f, getHeight()*0.8f, getWidth(), 0f, p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(x,getHeight()*0.3f,130.5f,p);
        canvas.drawCircle(x2,getHeight()*0.2f,130.5f,p);
        p.setColor(Color.BLACK);
        p.setTextSize(75);


        canvas.drawText(getContext().getString(R.string.monkey_hop),getWidth()*0.33f, getHeight()*0.1f, p);
        canvas.drawText("Score:" + count,getWidth()*0.33f, getHeight()*0.9f, p);
        canvas.drawBitmap(monkeyBMP,null,r,new Paint());

        //bananas
        canvas.drawBitmap(bananaBMP,null,r2,new Paint());
        r2.offset(bx,0);
        x2 += dx2;
        x+=dx;

        if(jumpCount-->0&&isJumping){
            r.offset(0,jumpSpeed);
            if(r.top>=height1){
                isJumping=false;
                r.offsetTo(r.left,height1);
                jumpSpeed=10;
            }
            if (r.top > r2.top-10 && r.top < r2.top+10 && r.left > r2.left-50 && r.left < r2.left+50){
                count +=1;
            }
        }else {
            jumpSpeed*=-1;
            jumpCount=51;
        }

        x%= (int) (getHeight()*0.8);
        x2%= (int) (getHeight()*0.8);
        if(x < 0){
            x = (int) (getHeight()*0.8);
        }
        if(x2 < 0) {
            x2 = (int) (getHeight() * 0.8);
        }
        if(r2.left >= getWidth()){
            r2.offsetTo(0,(int)(getHeight()*0.5));
        }
        invalidate();
    }

    public int getdX() {
        return dx;
    }

    public void setdX(int dX) {
        this.dx = dX;
    }

    public int getDx2() {
        return dx2;
    }

    public void setDx2(int dX2) {
        this.dx2 = dX2;
    }
    public int getHeight1() {
        return height1;
    }

    public void setHeight1(int x) {
        this.height1 = x;
    }
    public int getHeight2() {
        return height2;
    }

    public void setHeight2(int x) {
        this.height2 = x;
    }

}
