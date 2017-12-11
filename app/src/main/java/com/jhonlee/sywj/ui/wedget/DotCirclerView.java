package com.jhonlee.sywj.ui.wedget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public class DotCirclerView extends View {

    private Paint mPaint;
    private Paint mSelectPaint;
    private int mColor;
    private int mSelectColor;

    private int mWidth;
    private int mHeight;
    private int dotNum;
    private int mOneDotWidth;
    public DotCirclerView(Context context) {
        this(context,null);
    }

    public DotCirclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void  init(){
        mPaint = new Paint();
        mColor = Color.GRAY;
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);

        mSelectPaint = new Paint();
        mSelectColor = Color.WHITE;
        mSelectPaint.setColor(mSelectColor);
        mSelectPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidthMeasure(widthMeasureSpec);
        mHeight = getHeightMeasure(heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
    }
    private int getWidthMeasure(int measureSpec){
        int defaultsize = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED: //如果没有指定大小，就设置为默认大小
                defaultsize = 120;
                break;
            case MeasureSpec.AT_MOST: //如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                defaultsize = size;
                break;
            case MeasureSpec.EXACTLY: //如果是固定的大小，那就不要去改变它
                defaultsize = size;
                break;
        }
        return defaultsize;
    }
    private int getHeightMeasure(int measureSpec){
        int defaultsize = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED: //如果没有指定大小，就设置为默认大小
                defaultsize = 50;
                break;
            case MeasureSpec.AT_MOST: //如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                defaultsize = size;
                break;
            case MeasureSpec.EXACTLY: //如果是固定的大小，那就不要去改变它
                defaultsize = size;
                break;
        }
        return defaultsize;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(30,30,7,mSelectPaint);
        canvas.translate(30,0);
        canvas.drawCircle(30,30,7,mSelectPaint);
        canvas.translate(30,0);
        canvas.drawCircle(30,30,7,mSelectPaint);
    }
}
