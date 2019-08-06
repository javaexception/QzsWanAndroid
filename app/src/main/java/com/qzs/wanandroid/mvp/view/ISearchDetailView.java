package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

import java.util.List;

public interface ISearchDetailView extends IBaseMvpView {



    /***
     * 获取首页list成功
     */
    void getMainListSuccess(MainListBean.DataBean dataBeans, String type);

    /***
     * 获取首页list失败
     */
    void getMainListFail();


    /***
     * 获取当前加载页数
     */
    int  getPage();

    /***
     * 获取关键词
     * @return
     */
    String  getK();

}
