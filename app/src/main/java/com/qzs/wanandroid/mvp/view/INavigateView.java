package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;

import java.util.List;

/**
 * @author qinzishuai
 * 描述： 导航view
 * 创建日期：2019/7/25
 *
 */
public interface INavigateView extends IBaseMvpView {


    /***
     * 获取导航list成功的回调
     */
    void navigateListSuccess(List<NavigateBean.DataBean> dataBean);

    /***
     * 获取导航list失败的回调
     */
    void navigateListFail();


}
