package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.mvp.model.IRegisterModel;
import com.qzs.wanandroid.utils.LogUtils;

public class RegisterModelImpl implements IRegisterModel {


    @Override
    public void handleRegister(String username, String password, String passwordagain, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {

        RetrofitFactory
                .getInstence()
                .register(username, password, passwordagain, new BaseObserver<CurrencyBean.DataBean>() {
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
