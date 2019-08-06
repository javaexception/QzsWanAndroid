package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;

/**
 * @author qinzishuai
 * 描述：  注册model
 * 创建日期：2019/7/23
 *
 */
public interface IRegisterModel {

    void handleRegister(String username, String password,String passwordagain ,OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);

}
