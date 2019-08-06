package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.ISearchDetailModel;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

import java.util.List;

public class SearchDetailModelImpl implements ISearchDetailModel {


    @Override
    public void handleSearchDetail(int  page, String k, final OnLoadDatasListener<MainListBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .searchDetail(page, k, new BaseObserver<MainListBean.DataBean>() {
                    @Override
                    protected void onSuccees(MainListBean.DataBean dataBeans) throws Exception {
                        onLoadDatasListener.onSuccess(dataBeans);
                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                         onLoadDatasListener.onFailure(error);
                    }
                });
    }
}
