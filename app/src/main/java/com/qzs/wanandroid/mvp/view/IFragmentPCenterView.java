package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.BannerBean;

import java.util.List;

public interface IFragmentPCenterView extends IBaseMvpView {

    /***
     * 登出成功
     */
    void loginOutSuccess(CurrencyBean.DataBean dataBean);

    /***
     * 登出失败
     */
    void LoginOutFail();


}
