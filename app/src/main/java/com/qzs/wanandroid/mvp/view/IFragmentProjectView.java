package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;

import java.util.List;

public interface IFragmentProjectView extends IBaseMvpView {


    /***
     * 获取项目title成功
     */
    void getProjectTitleSuccess(List<ProjectTitleBean.DataBean> dataBeanList);

    /***
     * 获取项目title失败
     */
    void getProjectTitleFail();

}
