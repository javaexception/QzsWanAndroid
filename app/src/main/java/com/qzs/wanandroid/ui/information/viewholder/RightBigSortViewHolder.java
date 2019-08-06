package com.qzs.wanandroid.ui.information.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.base.SimpleViewHolder;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;


public class RightBigSortViewHolder extends SimpleViewHolder<NavigateBean.DataBean.ArticlesBean> {

    TextView tvTitle;

    public RightBigSortViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<NavigateBean.DataBean.ArticlesBean> adapter) {
        super(itemView, adapter);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void refreshView(NavigateBean.DataBean.ArticlesBean data) {
        tvTitle.setText(data.header);
    }

}
