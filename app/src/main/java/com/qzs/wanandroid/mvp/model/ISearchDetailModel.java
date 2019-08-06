package com.qzs.wanandroid.mvp.model;

import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  搜索
 * 创建日期：2019/7/26
 *
 */
public interface ISearchDetailModel {

    void handleSearchDetail(int page,String k,OnLoadDatasListener<MainListBean.DataBean> onLoadDatasListener);

}
