package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;

/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/31
 *
 */
public interface IMyCollectModel {

    void handleMyCollectList(int page, OnLoadDatasListener<MyCollectBean.DataBean> onLoadDatasListener);

}
