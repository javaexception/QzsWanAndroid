package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;

import java.util.List;

public interface IFrProjectSecView extends IBaseMvpView {


    /***
     * 获取项目list成功
     */
    void getProjectListSuccess(ProjectListBean.DataBean dataBeanList,String type);

    /***
     * 获取项目list失败
     */
    void getProjectTitleFail();

    /***
     * 获取当前页
     */
    int getPage();

    /***
     * 获取分类ID
     */

     String getClassifyId();



    /***
     * 收藏成功
     */
    void collectSuccess();

    /***
     * 收藏失败
     */
    void collectFail();


    /***
     * 获取收藏的ID
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
