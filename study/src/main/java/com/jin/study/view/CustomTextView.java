package com.jin.study.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
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
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;

    /**************************构造函数*********************************/
    //会在new的时候进行调用
    // CustomTextView tv = new CustomTextView(context)
    public CustomTextView(Context context) {
        //让此构造函数调用第二个构造函数
        this(context,null);
    }

    //在布局中使用调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    //在布局中并使用style时调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        mText = array.getString(R.styleable.CustomTextView_customText);
        mTextColor = array.getColor(R.styleable.CustomTextView_customTextColor,mTextColor);
        mTextSize = array.getDimensionPixelSize(R.styleable.CustomTextView_customTextSize,mTextSize);
        //回收
        array.recycle();
    }

    /**
     * 自定义View的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取控件宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

//        if (widthMode == MeasureSpec.AT_MOST) {
//
//        } else if (widthMode == MeasureSpec.EXACTLY) {
//
//        } else if (widthMode == MeasureSpec.UNSPECIFIED) {
//
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文本
//        canvas.drawText();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
