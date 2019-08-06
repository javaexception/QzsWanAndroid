package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.ICollectModel;
import com.qzs.wanandroid.mvp.model.IFrProjectModel;
import com.qzs.wanandroid.mvp.model.impl.CollectModelImpl;
import com.qzs.wanandroid.mvp.model.impl.FrProjectModelImpl;
import com.qzs.wanandroid.mvp.view.IFrProjectSecView;
import com.qzs.wanandroid.mvp.view.IFragmentProjectView;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;
import com.qzs.wanandroid.utils.LogUtils;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  项目2层fragment -P层
 * 创建日期：2019/7/20
 *
 */
public class FrProjectSecPresenter extends BaseMvpPresenter<IFrProjectSecView> {
    /***
     * 获取项目list-model
     */
    private IFrProjectModel iFrProjectModel;
    /***
     * 收藏-model
     */
    private ICollectModel iCollectModel;


    public FrProjectSecPresenter() {

        this.iFrProjectModel = new FrProjectModelImpl();
        this.iCollectModel=new CollectModelImpl();
    }

    public  void  getProjectList(final String type){

        if (mView == null) return;

        iFrProjectModel.handleProjectList(mView.getPage(), mView.getClassifyId(), new OnLoadDatasListener<ProjectListBean.DataBean>() {
            @Override
            public void onSuccess(ProjectListBean.DataBean dataBean) {

          getView().getProjectListSuccess(dataBean,type);
            }

            @Override
            public void onFailure(String error) {

                getView().getProjectTitleFail();

            }
        });


    }

    /****
     * 站内收藏
     */
    public  void  handleCollectIn(){
        if (mView == null) return;
        getView().getLoadDialog().show();
        iCollectModel.handleCollectIn(mView.getCollectId(), new OnLoadDatasListener<CurrencyBean.DataBean>() {
            @Override
            public void onSuccess(CurrencyBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                getView().collectSuccess();

            }

            @Override
            public void onFailure(String error) {
                getView().collectFail();
                getView().cancelLoadDialog();

            }
        });

    }

    public   void   cancelCollect(){
        if (mView == null) return;
        getView().getLoadDialog().show();
        iCollectModel.handleCancelCollect(mView.getCollectId()+"", new OnLoadDatasListener<CurrencyBean.DataBean>() {
            @Override
            public void onSuccess(CurrencyBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                getView().CancelCollectSuccess();
            }

            @Override
            public void onFailure(String error) {
                getView().cancelLoadDialog();
                getView().CancelCollectFail();
            }
        });
    }


}
