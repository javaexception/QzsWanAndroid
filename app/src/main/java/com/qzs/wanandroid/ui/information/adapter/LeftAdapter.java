package com.qzs.wanandroid.ui.information.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.base.SimpleViewHolder;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.ui.information.viewholder.LeftViewHolder;


public class LeftAdapter extends SimpleRecyclerAdapter<NavigateBean.DataBean> {

    private int mSelectedPosition;

    @Override
    public SimpleViewHolder<NavigateBean.DataBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LeftViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_search_sort_left, parent, false), this);
    }

    public void setSelectedPosition(int position) {
        mListData.get(mSelectedPosition).isSelected = false;
        notifyItemChanged(mSelectedPosition);
        mListData.get(position).isSelected = true;
        notifyItemChanged(position);
        mSelectedPosition = position;
    }
}
