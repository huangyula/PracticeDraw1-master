package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint mPaint;
    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mPaint.setAntiAlias(true);
        int width=canvas.getWidth();
        int height=canvas.getHeight();
        RectF rectF=new RectF(width/3,height/3,(width/3)*2,(height/3)*2);
        canvas.drawArc(rectF,-10,-100,true,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);//划线模式
        canvas.drawArc(rectF,-120,-60,false,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF,20,140,false,mPaint);
    }
}
