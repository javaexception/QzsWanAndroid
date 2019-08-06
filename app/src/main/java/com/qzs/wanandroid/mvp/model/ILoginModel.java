package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

/**
 * @author qinzishuai
 * 描述：  登录model
 * 创建日期：2019/7/23
 *
 */
public interface ILoginModel {

    void handleLogin(String username, String  password, OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);


    void handleLoginOut(OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);
}
