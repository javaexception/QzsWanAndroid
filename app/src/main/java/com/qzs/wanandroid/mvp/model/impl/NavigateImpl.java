package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IFrProjectModel;
import com.qzs.wanandroid.mvp.model.INavigateModel;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;
import com.qzs.wanandroid.utils.LogUtils;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/20
 *
 */
public class NavigateImpl implements INavigateModel {

    @Override
    public void handleNavigate(final OnLoadDatasListener<List<NavigateBean.DataBean>> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .navigateList(new BaseObserver<List<NavigateBean.DataBean>>() {
                    @Override
                    protected void onSuccees(List<NavigateBean.DataBean> dataBean) throws Exception {
                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);

                    }
                });
    }
}
