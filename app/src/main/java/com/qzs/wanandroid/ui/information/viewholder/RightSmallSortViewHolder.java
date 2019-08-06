package com.qzs.wanandroid.ui.information.viewholder;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.base.SimpleViewHolder;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;


public class RightSmallSortViewHolder extends SimpleViewHolder<NavigateBean.DataBean.ArticlesBean> {

    private TextView textView;

    public RightSmallSortViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<NavigateBean.DataBean.ArticlesBean> adapter) {
        super(itemView, adapter);
        textView = itemView.findViewById(R.id.tv_small);
    }

    @Override
    protected void refreshView(NavigateBean.DataBean.ArticlesBean data) {
        textView.setText(data.getTitle());
    }
}
