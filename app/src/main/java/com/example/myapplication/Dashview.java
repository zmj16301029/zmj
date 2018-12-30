package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by 16301029 on 2018/9/30.
 */

public class Dashview extends View
{
    private Paint paint;
    private int inWidth = 200;
    private int circleWidth = 80;

    public Dashview(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();
        float x = viewWidth/2;
        float y = viewHeight/5;
        RectF mrectF= new RectF(x - inWidth - circleWidth / 2, y - inWidth - circleWidth / 2, x + inWidth + circleWidth / 2, y + inWidth + circleWidth/2);
        canvas.drawCircle(x,y,inWidth, paint);
        drawNormalRing(canvas, mrectF);
        drawColorRing(x,y,canvas,mrectF);
        paint.setTextSize(50);
        canvas.rotate(180, x, y);
        paint.setColor(Color.GREEN);
        canvas.drawText("目标10000步", 390, 300, paint);
        paint.setTextSize(90);
        canvas.drawText("7500步", 390, 400, paint);
    }

    private void drawNormalRing(Canvas canvas, RectF mrectF)
    {
        Paint nPaint = new Paint(paint);
        nPaint.setStyle(Paint.Style.STROKE);
        nPaint.setStrokeWidth(circleWidth);
        nPaint.setColor(Color.GRAY);
        canvas.drawArc(mrectF, 360, 360, false, nPaint);
    }

    private void drawColorRing(float x, float y, Canvas canvas, RectF mrectF)
    {
        int color[] = new int[3];   //渐变颜色数组
        //圆环渐变的颜色
        color[0] = Color.parseColor("#FFD300");
        color[1] = Color.parseColor("#FF0084");
        color[2] = Color.parseColor("#16FF00");
        Paint cpaint = new Paint(paint);
        cpaint.setStyle(Paint.Style.STROKE);
        cpaint.setStrokeWidth(circleWidth);
        cpaint.setShader(new SweepGradient(x, y, color, null));
        canvas.rotate(-180, x, y);
        canvas.drawArc(mrectF,360,270, false, cpaint);
        cpaint.setShader(null);
    }
}
