package com.qzs.wanandroid.ui.information.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.base.SimpleViewHolder;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;


public class LeftViewHolder extends SimpleViewHolder<NavigateBean.DataBean> {

    /**
     * tvName显示大类名称，view是显示被选中的黄色标记
     */
    private TextView tvName;
    private View view;

    public LeftViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<NavigateBean.DataBean> adapter) {
        super(itemView, adapter);
        tvName = (TextView) itemView.findViewById(R.id.tv_left);
        view = itemView.findViewById(R.id.view);
    }

    @Override
    protected void refreshView(NavigateBean.DataBean data) {
       tvName.setText(data.getName());
        //item点击后背景的变化
        if (data.isSelected) {
            view.setVisibility(View.VISIBLE);
            tvName.setBackgroundResource(R.color.color_107);
            tvName.setTextColor(getContext().getResources().getColor(R.color.color_1002));
        } else {
            view.setVisibility(View.GONE);
            tvName.setBackgroundResource(R.color.color_109);
            tvName.setTextColor(getContext().getResources().getColor(R.color.color_100));
        }
    }
}
