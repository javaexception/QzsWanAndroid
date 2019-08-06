package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.IFrProjectModel;
import com.qzs.wanandroid.mvp.model.impl.FrHomeModelImpl;
import com.qzs.wanandroid.mvp.model.impl.FrProjectModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentPCenterView;
import com.qzs.wanandroid.mvp.view.IFragmentProjectView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;
import com.qzs.wanandroid.utils.LogUtils;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  项目fragment -P层
 * 创建日期：2019/7/20
 *
 */
public class FrProjectPresenter extends BaseMvpPresenter<IFragmentProjectView> {

    private IFrProjectModel iFrProjectModel;


    public FrProjectPresenter() {

        this.iFrProjectModel = new FrProjectModelImpl();
    }

    /***
     * 获取首页list
     */
    public  void  getProjectTitle(){

        if (mView == null) return;
        iFrProjectModel.handleProjectTitle(new OnLoadDatasListener<List<ProjectTitleBean.DataBean>>() {
            @Override
            public void onSuccess(List<ProjectTitleBean.DataBean> dataBean) {
                LogUtils.d("Pceng--- "+dataBean);
                getView().getProjectTitleSuccess(dataBean);

            }

            @Override
            public void onFailure(String error) {
                getView().cancelLoadDialog();
                getView().getProjectTitleFail();

            }
        });


    }
}
