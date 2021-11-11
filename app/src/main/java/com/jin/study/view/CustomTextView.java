package com.jin.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

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
    /**************************构造函数*********************************/
    //会在new的时候进行调用
    // CustomTextView tv = new CustomTextView(context)
    public CustomTextView(Context context) {
        super(context);
    }

    //在布局中使用调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //在布局中并使用style时调用
    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 自定义View的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取控件宽高的模式（match_parent、wrap_content、100dp等）
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST) {

        } else if (widthMode == MeasureSpec.EXACTLY) {

        } else if (widthMode == MeasureSpec.UNSPECIFIED) {

        }
    }
}
