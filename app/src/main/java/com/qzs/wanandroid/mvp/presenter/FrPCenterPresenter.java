package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.mvp.model.impl.LoginModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentPCenterView;

public class FrPCenterPresenter extends BaseMvpPresenter<IFragmentPCenterView> {

    private ILoginModel  iLoginModel;



    public FrPCenterPresenter() {

        this.iLoginModel = new LoginModelImpl();
    }

    public   void   loginOut(){
        if (mView == null) return;
      getView().getLoadDialog().show();
        iLoginModel.handleLoginOut(new OnLoadDatasListener<CurrencyBean.DataBean>() {
            @Override
            public void onSuccess(CurrencyBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                mView.loginOutSuccess(dataBean);
            }

            @Override
            public void onFailure(String error) {
                getView().cancelLoadDialog();
                getView().LoginOutFail();

            }
        });

    }


}
