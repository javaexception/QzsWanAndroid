package com.qzs.wanandroid.ui.information.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.base.SimpleViewHolder;
import com.qzs.wanandroid.common.ItemType;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.ui.information.viewholder.RightBigSortViewHolder;
import com.qzs.wanandroid.ui.information.viewholder.RightSmallSortViewHolder;
import com.qzs.wanandroid.utils.LogUtils;


public class RightAdapter extends SimpleRecyclerAdapter<NavigateBean.DataBean.ArticlesBean> {


    @Override
    public SimpleViewHolder<NavigateBean.DataBean.ArticlesBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemType.BIG_SORT) {
            LogUtils.d("111111111111111111111");
            return new RightBigSortViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_right_big_sort, parent, false), this);
        } else {

            LogUtils.d("22222222222222222222");
            return new RightSmallSortViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_right_small_sort, parent, false), this);
        }
    }

    @Override
        public int getItemViewType(int position) {
        return mListData.get(position).viewType;
    }
}
