package com.qzs.wanandroid.ui.information.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;

import java.util.ArrayList;
import java.util.List;

public class MyCollectAdapter extends BaseQuickAdapter<MyCollectBean.DataBean.DatasBean, BaseViewHolder> {

    public interface onDeleteListtener {
        void delete(int position);
    }

    private onDeleteListtener onDelete;

    public void setOnDelete(onDeleteListtener onDelete) {
        this.onDelete = onDelete;
    }


    List<MyCollectBean.DataBean.DatasBean> data;
    /**
     * 上下文
     */
    private Context context;

    public MyCollectAdapter(Context context, int layoutResId, @Nullable List<MyCollectBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
        this.context=context;
        this.data=data;

    }


    @Override
    protected void convert(BaseViewHolder helper,MyCollectBean.DataBean.DatasBean item) {

        helper.setText(R.id.item_tv_name,item.getAuthor()+"");
        helper.setText(R.id.item_tv_time,item.getNiceDate()+"");
        helper.setText(R.id.item_tv_title,item.getTitle()+"");
        helper.setText(R.id.item_tv_label,"完整项目");
        helper.addOnClickListener(R.id.btnDelete);



    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 下拉刷新
     */
    public void refresh(MyCollectBean.DataBean bean) {

        //刷新数据
        if (data==null){
            data=new ArrayList<>();
        }data.clear();
        data.addAll(bean.getDatas());
        notifyDataSetChanged();
    }


    /**
     * 上拉加载
     */
    public void Load(List<MyCollectBean.DataBean.DatasBean> loadList) {
        //刷新数据
        if (data==null){
            data=new ArrayList<>();
        }

        //增加数据
        int position = data.size();
        data.addAll(position, loadList);

        notifyItemInserted(position);
    }

}
