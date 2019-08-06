package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IBannerModel;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.ui.information.bean.BannerBean;
import com.qzs.wanandroid.utils.LogUtils;

import java.util.List;

public class BannerModelImpl implements IBannerModel {



    @Override
    public void handleBanner(final OnLoadDatasListener<List<BannerBean.DataBean>> onLoadDatasListener) {
        RetrofitFactory.getInstence().getBanner(new BaseObserver<List<BannerBean.DataBean>>() {
            @Override
            protected void onSuccees(List<BannerBean.DataBean> dataBeans) throws Exception {
                onLoadDatasListener.onSuccess(dataBeans);

            }

            @Override
            protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                onLoadDatasListener.onFailure(error);

            }
        });
    }
}
