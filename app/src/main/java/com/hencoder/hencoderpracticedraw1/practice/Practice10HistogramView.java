package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private static final String NAME = "直方图";
    private Paint paint;
    private float mWidth;
    private float space;
    private float offset=8;
    private int n=7;//长方块个数
    private float y;//纵坐标的长度
    private float topY=10;
    private float bottomX=100;
    private float size=30;//标题的大小
    private float rect_size=20;//每个方块对应的标题大小
    private List<Data> mDataList=new ArrayList<>();
    Data mData;

    public Practice10HistogramView(Context context) {
        super(context);

    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);

        //模拟数据
        mData=new Data("Froyo",60,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("GB",120,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("ICS",200,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("JB",100,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("KitKat",40,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("L",90,Color.YELLOW);
        mDataList.add(mData);
        mData=new Data("M",80,Color.YELLOW);
        mDataList.add(mData);

    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=canvas.getWidth();
        int height=canvas.getHeight();

        mWidth=width/(n+2);
        y=height-(topY+bottomX);
        space=mWidth-offset;

        //画两条线
        paint.setColor(Color.WHITE);
        float pts[]={mWidth,topY,mWidth,y+topY,mWidth,y+topY,width-offset,y+topY};
        canvas.drawLines(pts,paint);

        //画标题
        paint.setTextSize(30);
        canvas.drawText(NAME,(width-offset-mWidth)/2-paint.measureText(NAME)/2+mWidth,y+topY+size+rect_size+20,paint);

        if(mDataList!=null&&mDataList.size()>0){
            RectF rectF;
            //画每个方块
            for(int i=0;i<n;i++){
                mData=mDataList.get(i);

                //画文字
                paint.setColor(Color.WHITE);
                paint.setTextSize(20);
                paint.setStrokeWidth(2);
                float textSize=paint.measureText(mData.getName());
                canvas.drawText(mData.getName(),mWidth*(i+1)+offset+(space-textSize)/2,y+topY+rect_size+10,paint);

                //画方块
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(mData.getColor());
                float rect_height=mData.getNumber();
                //边界处理
                if(rect_height>y){
                    rect_height=y;
                }else if(rect_height<0){
                    rect_height=0;
                }
                rectF=new RectF(mWidth*(i+1)+offset,y+topY-rect_height,mWidth*(i+1)+offset+space,y+topY);
                canvas.drawRect(rectF,paint);
            }
        }

    }
}
