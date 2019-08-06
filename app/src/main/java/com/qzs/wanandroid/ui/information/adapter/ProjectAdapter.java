package com.qzs.wanandroid.ui.information.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.imageloader.GlideUtils;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;

import java.util.ArrayList;
import java.util.List;
/**
 * @author qinzishuai
 * 描述：  项目模块adapter
 * 创建日期：2019/7/22
 *
 */
public class ProjectAdapter extends BaseQuickAdapter<ProjectListBean.DataBean.DatasBean, BaseViewHolder> {


    List<ProjectListBean.DataBean.DatasBean> data;
    /**
     * 上下文
     */
    private Context context;

    public ProjectAdapter(Context context, int layoutResId, @Nullable List<ProjectListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
        this.context=context;
        this.data=data;

    }


    @Override
    protected void convert(BaseViewHolder helper,ProjectListBean.DataBean.DatasBean item) {

        helper.setText(R.id.item_tv_name,item.getAuthor()+"");
        helper.setText(R.id.item_tv_title,item.getTitle()+"");
        helper.setText(R.id.item_tv_time,item.getNiceDate()+"");
        helper.setText(R.id.item_tv_desc,item.getDesc()+"");

        //头像
        GlideUtils.loadImage(mContext, item.getEnvelopePic(), (ImageView) helper.getView(R.id.item_iv_img));
        helper.addOnClickListener(R.id.item_iv_collect);
if (item.isCollect()){
    helper.setImageResource(R.id.item_iv_collect,R.mipmap.ic_star_select);
}else {
    helper.setImageResource(R.id.item_iv_collect,R.mipmap.ic_star_normal);
}


    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 下拉刷新
     */
    public void refresh(ProjectListBean.DataBean bean) {

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
    public void Load(List<ProjectListBean.DataBean.DatasBean> loadList) {
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
