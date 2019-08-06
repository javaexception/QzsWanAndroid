package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.IMyCollectModel;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;

public class MyCollectModelImpl implements IMyCollectModel {


    @Override
    public void handleMyCollectList(int page, final OnLoadDatasListener<MyCollectBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .getMyCollect(page, new BaseObserver<MyCollectBean.DataBean>() {
                    @Override
                    protected void onSuccees(MyCollectBean.DataBean dataBean) throws Exception {

                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);
                    }
                });
    }
}
