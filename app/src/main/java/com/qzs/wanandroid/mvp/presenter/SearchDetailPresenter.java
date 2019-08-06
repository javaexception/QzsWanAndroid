package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.ISearchDetailModel;
import com.qzs.wanandroid.mvp.model.impl.FrHomeModelImpl;
import com.qzs.wanandroid.mvp.model.impl.SearchDetailModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentHomeView;
import com.qzs.wanandroid.mvp.view.ISearchDetailView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  首页搜索详情
 * 创建日期：2019/7/24
 *
 */
public class SearchDetailPresenter extends BaseMvpPresenter<ISearchDetailView>   {
    /***
     *   首页-fragment  model
     */
  private ISearchDetailModel iSearchDetailModel;

    public SearchDetailPresenter() {

        this.iSearchDetailModel = new SearchDetailModelImpl();
    }

    public  void  getSearchDetial(final String type){

        if (mView == null) return;

        getView().getLoadDialog().show();
        iSearchDetailModel.handleSearchDetail(mView.getPage(), mView.getK(), new OnLoadDatasListener<MainListBean.DataBean>() {
            @Override
            public void onSuccess(MainListBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                getView().getMainListSuccess(dataBean,type);
            }

            @Override
            public void onFailure(String error) {
                getView().getMainListFail();

            }
        });




    }
}
