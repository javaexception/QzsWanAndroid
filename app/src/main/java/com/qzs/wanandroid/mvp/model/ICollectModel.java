package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;

/**
 * @author qinzishuai
 * 描述：  登录model
 * 创建日期：2019/7/23
 *
 */
public interface ICollectModel {
    /****
     * |站内收藏
     * @param id
     * @param onLoadDatasListener
     */
    void handleCollectIn(String id, OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);

    /***
     * 取消收藏
     */
    void handleCancelCollect(String id, OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);

}
