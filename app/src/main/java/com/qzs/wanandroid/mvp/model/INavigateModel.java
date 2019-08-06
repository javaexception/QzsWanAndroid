package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：导航
 * 创建日期：2019/7/25
 *
 */
public interface INavigateModel {

    void handleNavigate(OnLoadDatasListener<List<NavigateBean.DataBean>> onLoadDatasListener);

}
