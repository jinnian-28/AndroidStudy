package com.jin.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @ProjectName: Study
 * @Package: com.jin.study.view
 * @Description: 解决ScrollView嵌套ListView显示不全
 * @Author: jin-mo
 * @CreateDate: 2021/11/11 11:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/11
 * @UpdateRemark: 更新说明
 */
public class CustomListView extends ListView {

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //进入了此方法所有无法显示完全
//        if (heightMode == MeasureSpec.UNSPECIFIED) {
//            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
//                    getVerticalFadingEdgeLength() * 2;
//        }
        //需要进入此方法
//        if (heightMode == MeasureSpec.AT_MOST) {
//        // TODO: after first layout we should maybe start at the first visible position, not 0
//            heightSize = measureHeightOfChildren(widthMeasureSpec, 0, NO_POSITION, heightSize, -1);
//        }

        //Integer.MAX_VALUE >> 2  ,右移两位变成30的值，MeasureSpec.makeMeasureSpec会变成一个32位值
        //(size & ~MODE_MASK)保留了size后30位的数据，抹掉了高两位的数据。(mode & MODE_MASK)以同样的方式保留了高两位的测量模式。最后通过|运算将两个数据合并
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
