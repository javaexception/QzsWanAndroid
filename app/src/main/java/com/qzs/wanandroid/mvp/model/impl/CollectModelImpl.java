package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.ICollectModel;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.utils.LogUtils;

public class CollectModelImpl implements ICollectModel {


    @Override
    public void handleCollectIn(String id, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {


        RetrofitFactory
                .getInstence().collectIn(id, new BaseObserver<CurrencyBean.DataBean>() {
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

    @Override
    public void handleCancelCollect(String id, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence().cancelCollect(id, new BaseObserver<CurrencyBean.DataBean>() {
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
