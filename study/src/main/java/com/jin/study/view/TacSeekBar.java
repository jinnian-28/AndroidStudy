package com.jin.study.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.jin.study.R;

/**
 * @ProjectName: Study
 * @Package: com.jin.study.view
 * @Description: 弧形
 * @Author: jin-mo
 * @CreateDate: 2021/11/12 17:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/12
 * @UpdateRemark: 更新说明
 */
public class TacSeekBar extends View {

    /**
     * 背景进度条颜色
     */
    private int mOuterColor = Color.RED;
    /**
     * 二级进度条颜色
     */
    private int mInnerColor = Color.GREEN;

    /**
     * 进度条宽度
     */
    private int mBorderWidth = 20;//20px

    /**
     * 文字大小
     */
    private int mTacTextSize;

    /**
     * 文字颜色
     */
    private int mTacTextColor;

    private Paint mOuterPaint;
    private Paint mInnerPaint;


    public TacSeekBar(Context context) {
        this(context, null);
    }

    public TacSeekBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TacSeekBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TacSeekBar);
        mOuterColor = array.getColor(R.styleable.TacSeekBar_outerColor, mOuterColor);
        mInnerColor = array.getColor(R.styleable.TacSeekBar_innerColor, mInnerColor);
        mBorderWidth = (int) array.getDimension(R.styleable.TacSeekBar_borderWidth, mBorderWidth);
        mTacTextColor = array.getColor(R.styleable.TacSeekBar_tacTextColor, mTacTextColor);
        mTacTextSize = array.getDimensionPixelSize(R.styleable.TacSeekBar_tacTextSize, mTacTextSize);
        array.recycle();

        //背景进度条
        mOuterPaint = new Paint();
        mOuterPaint.setAntiAlias(true);
        mOuterPaint.setStrokeWidth(mBorderWidth);
        mOuterPaint.setColor(mOuterColor);
        mOuterPaint.setStrokeCap(Paint.Cap.ROUND);
        mOuterPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);


        setMeasuredDimension(width > height ? height : width, width > height ? height : width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制背景
        int center = getHeight()/2;
        int radius = getWidth()/2-mBorderWidth;

        RectF rectF = new RectF(center-radius, center-radius, center+radius, center+radius);
        canvas.drawArc(rectF, -180, 180, false, mOuterPaint);
        //绘制二级

        //绘画文字
    }
}
