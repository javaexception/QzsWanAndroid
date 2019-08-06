package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/20
 *
 */
public interface IFrProjectModel {

    void handleProjectTitle(OnLoadDatasListener<List<ProjectTitleBean.DataBean>> onLoadDatasListener);

    void handleProjectList(int page, String id,OnLoadDatasListener<ProjectListBean.DataBean> onLoadDatasListener);
}
