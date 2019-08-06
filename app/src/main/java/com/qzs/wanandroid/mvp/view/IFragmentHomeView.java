package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.BannerBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

import java.util.List;

public interface IFragmentHomeView extends IBaseMvpView {



    /***
     * 获取首页list成功
     */
    void getMainListSuccess(MainListBean.DataBean dataBean, String type);

    /***
     * 获取首页list失败
     */
    void getMainListFail();


    /***
     * 获取当前加载页数
     */
    int  getPage();


    /***
     * 获取首页banner成功
     */
    void getBannerSuccess(List<BannerBean.DataBean> dataBean);

    /***
     * 获取首页banner失败
     */
    void getBannerFail();


}
