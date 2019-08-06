package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;

public interface IMyCollectView extends IBaseMvpView {



    /***
     * 获取收藏list成功
     */
    void getMainListSuccess(MyCollectBean.DataBean dataBean, String type);

    /***
     * 获取收藏list失败
     */
    void getMainListFail();


    /***
     * 获取当前加载页数
     */
    int  getPage();



    /***
     * 获取ID
     */
    String  getCollectId();

    /***
     * 取消收藏成功
     */
    void CancelCollectSuccess();

    /***
     * 取消收藏失败
     */
    void CancelCollectFail();
}
