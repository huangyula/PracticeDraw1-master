package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private Path path;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawPath() 方法画心形
        float width=canvas.getWidth();
        float height=canvas.getHeight();

        RectF rectF=new RectF(width/2,height/2-50,width/2+100,height/2+50);
        path.arcTo(rectF,30,-220);
        rectF=new RectF(width/2-100,height/2-50,width/2,height/2+50);
        path.arcTo(rectF,0,-220);
        path.lineTo(width/2,height/2+150);
        path.close();
        canvas.drawPath(path,paint);

    }
}
