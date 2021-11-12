package com.jin.study.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.jin.study.R;

/**
 * @ProjectName: Study
 * @Package: com.jin.study.view
 * @Description: 自定义TextView
 * @Author: jin-mo
 * @CreateDate: 2021/11/11 9:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/11
 * @UpdateRemark: 更新说明
 */
public class CustomTextView extends View {

    private String mText;
    //默认像素sp
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;

    //画笔，绘制文字
    private Paint mPaint;

    private final String TAG = "CustomTextView";

    /**************************构造函数*********************************/
    //会在new的时候进行调用
    // CustomTextView tv = new CustomTextView(context)
    public CustomTextView(Context context) {
        //让此构造函数调用第二个构造函数
        this(context, null);
    }

    //在布局中使用调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //在布局中并使用style时调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        mText = array.getString(R.styleable.CustomTextView_customText);
        mTextColor = array.getColor(R.styleable.CustomTextView_customTextColor, mTextColor);
        mTextSize = array.getDimensionPixelSize(R.styleable.CustomTextView_customTextSize, sp2px(mTextSize));
        //回收
        array.recycle();

        mPaint = new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        //文字大小
        mPaint.setTextSize(mTextSize);
        //文字颜色
        mPaint.setColor(mTextColor);
    }

    private int sp2px(int spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, getResources().getDisplayMetrics());
    }

    /**
     * 自定义View的测量方法
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //控件的宽高，与字体的长度，大小有关
        int width, height;

        //绘画相关的工具类
        Rect bound = new Rect();

        //获取控件宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);


        if (widthMode == MeasureSpec.AT_MOST) {
            //获取文本的Rect
            mPaint.getTextBounds(mText, 0, mText.length(), bound);
            //Padding-（paddingStart和paddingEnd在minSdkVersion17及以上才行）
            width = bound.width()+getPaddingLeft()+getPaddingRight();
            height = bound.height()+getPaddingTop()+getPaddingBottom();
        } else {
            width = MeasureSpec.getSize(widthMeasureSpec);
            height = MeasureSpec.getSize(heightMeasureSpec);
        }

        //设置控件的宽高
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文本
        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        Log.d(TAG,"fontMetricsInt.bottom："+fontMetricsInt.bottom);
        Log.d(TAG,"fontMetricsInt.top："+fontMetricsInt.top);
        int leading = (fontMetricsInt.bottom -fontMetricsInt.top)/2-fontMetricsInt.bottom;
        int baseLine = getHeight()/2+leading;
        canvas.drawText(mText,getPaddingLeft(),baseLine,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
