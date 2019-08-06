package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;
import com.qzs.wanandroid.utils.LogUtils;

import java.util.List;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void handleLogin(String username, String password, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .login(username, password, new BaseObserver<CurrencyBean.DataBean>() {
                    @Override
                    protected void onSuccees(CurrencyBean.DataBean dataBean) throws Exception {
                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);

                    }
                });

    }

    /***
     * 登出
     * @param onLoadDatasListener
     */
    @Override
    public void handleLoginOut(final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .loginOut(new BaseObserver<CurrencyBean.DataBean>() {
                    @Override
                    protected void onSuccees(CurrencyBean.DataBean dataBean) throws Exception {
                        onLoadDatasListener.onSuccess(dataBean);
                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                      onLoadDatasListener.onFailure(error);
                    }
                });
    }
}
