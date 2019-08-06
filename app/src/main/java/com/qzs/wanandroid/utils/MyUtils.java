package com.qzs.wanandroid.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MyUtils {

    public static void moveToMiddle(RecyclerView recyclerView, int position) {
        //先从RecyclerView的LayoutManager中获取当前第一项和最后一项的Position
        int firstItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int lastItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
        //中间位置
        int middle = (firstItem + lastItem)/2;
        // 取绝对值，index下标是当前的位置和中间位置的差，下标为index的view的top就是需要滑动的距离
        int index = (position - middle) >= 0 ? position - middle : -(position - middle);
        //左侧列表一共有getChildCount个Item，如果>这个值会返回null，程序崩溃，如果>getChildCount直接滑到指定位置,或者,都一样啦
        if (index >= recyclerView.getChildCount()) {
            recyclerView.scrollToPosition(position);
        } else {
            //如果当前位置在中间位置上面，往下移动，这里为了防止越界
            if(position < middle) {
                recyclerView.scrollBy(0, -recyclerView.getChildAt(index).getTop());
                // 在中间位置的下面，往上移动
            } else {
                recyclerView.scrollBy(0, recyclerView.getChildAt(index).getTop());
            }
        }
    }
}
