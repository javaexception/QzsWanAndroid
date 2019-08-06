package com.qzs.wanandroid.mvp.model.impl;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.http.BaseObserver;
import com.qzs.wanandroid.http.RetrofitFactory;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.IFrProjectModel;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
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
public class FrProjectModelImpl implements IFrProjectModel {


    @Override
    public void handleProjectTitle(final OnLoadDatasListener<List<ProjectTitleBean.DataBean>> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .getProjectTitle( new BaseObserver<List<ProjectTitleBean.DataBean>>() {
                    @Override
                    protected void onSuccees(List<ProjectTitleBean.DataBean> dataBean) throws Exception {

                        LogUtils.d("model--- "+dataBean);

                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);
                    }
                });
    }

    @Override
    public void handleProjectList(int page, String id, final OnLoadDatasListener<ProjectListBean.DataBean> onLoadDatasListener) {
        RetrofitFactory
                .getInstence()
                .getProjectList( page,id,new BaseObserver<ProjectListBean.DataBean>() {
                    @Override
                    protected void onSuccees(ProjectListBean.DataBean dataBean) throws Exception {

                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);
                    }
                });
    }
}
