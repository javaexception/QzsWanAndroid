package com.qzs.wanandroid.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * @author pengbo
 * @date 2018/5/22
 */
public class SimpleViewHolder<T> extends RecyclerView.ViewHolder{

    private ItemViewClickListener itemViewClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    public SimpleRecyclerAdapter<T> adapter;
    private View itemView;

    public SimpleViewHolder(View itemView) {
        this(itemView, null);
    }

    /**
     * 传入adapter 设置onItemClickListener才会有效
     * @param itemView
     * @param adapter
     */
    public SimpleViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<T> adapter) {
        super(itemView);
        this.itemView = itemView;
        if (adapter != null) {
            itemViewClickListener = new ItemViewClickListener();
            itemView.setOnClickListener(itemViewClickListener);
            onItemLongClickListener=new OnItemLongClickListener();
            itemView.setOnLongClickListener(onItemLongClickListener);
            this.adapter = adapter;
        }
    }

    public final void refresh(T data, int position) {
        if (itemViewClickListener != null) {
            itemViewClickListener.data = data;
            itemViewClickListener.position = position;
        }
        if (onItemLongClickListener != null) {
            onItemLongClickListener.data = data;
            onItemLongClickListener.position = position;
        }
        refreshView(data);
    }

    public final void refreshItemWidget(T data, int position, List<Object> payloads) {
        if (itemViewClickListener != null) {
            itemViewClickListener.data = data;
            itemViewClickListener.position = position;
        }
        if (onItemLongClickListener != null) {
            onItemLongClickListener.data = data;
            onItemLongClickListener.position = position;
        }
        refreshItemWidgetView(data,payloads);
    }

    protected Context getContext() {
        return itemView.getContext();
    }

    protected void refreshView(T data) {};

    protected void refreshItemWidgetView(T data, List<Object> payloads){}

    private class ItemViewClickListener implements View.OnClickListener {

        T data;

        int position;

        @Override
        public void onClick(View v) {
            adapter.onItemClick(data, position);
        }
    }

    private class OnItemLongClickListener implements View.OnLongClickListener {
     T data;
     int position;

     @Override
     public boolean onLongClick(View view) {
         adapter.onItemLongClick(data,position);
         return true;
     }
    }
}