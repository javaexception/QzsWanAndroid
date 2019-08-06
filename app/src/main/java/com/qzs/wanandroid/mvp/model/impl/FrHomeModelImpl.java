package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;

public class FrHomeModelImpl implements IFrHomeModel {

    /***
     * 获取首页list
     * @param onLoadDatasListener
     */
    @Override
    public void handleHomeList(int page, final OnLoadDatasListener<MainListBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .getHomeList(page, new BaseObserver<MainListBean.DataBean>() {
                    @Override
                    protected void onSuccees(MainListBean.DataBean dataBean) throws Exception {

                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);
                    }
                });
    }
}
