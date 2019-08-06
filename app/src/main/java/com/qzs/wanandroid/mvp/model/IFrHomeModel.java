package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

/**
 * @author qinzishuai
 * 描述： 主页fragment-model
 * 创建日期：2019/7/17
 *
 */
public interface IFrHomeModel {

    void handleHomeList(int page,OnLoadDatasListener<MainListBean.DataBean> onLoadDatasListener);

}
