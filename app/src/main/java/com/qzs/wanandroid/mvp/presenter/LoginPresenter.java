package com.qzs.wanandroid.mvp.presenter;

import android.text.TextUtils;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.mvp.model.impl.FrHomeModelImpl;
import com.qzs.wanandroid.mvp.model.impl.LoginModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentHomeView;
import com.qzs.wanandroid.mvp.view.ILoginView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.utils.CommonUtil;
import com.qzs.wanandroid.utils.LogUtils;

/**
 * @author qinzishuai
 * 描述：   登录
 * 创建日期：2019/7/23
 *
 */
public class LoginPresenter extends BaseMvpPresenter<ILoginView>   {

    private ILoginModel  iLoginModel;


    public   LoginPresenter(){
        this.iLoginModel=new LoginModelImpl();

    }


    public void handleLogin(){
        if (mView == null) return;

        if (TextUtils.isEmpty(mView.getUser()) || TextUtils.isEmpty(mView.getPassword())) {
            CommonUtil.showToast("用户名或密码不能为空");
            return;
        }
        getView().getLoadDialog().show();
        iLoginModel.handleLogin(mView.getUser(), mView.getPassword(), new OnLoadDatasListener<CurrencyBean.DataBean>() {
            @Override
            public void onSuccess(CurrencyBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                getView().loginSuccess();

            }

            @Override
            public void onFailure(String error) {
                getView().cancelLoadDialog();
                getView().loginFail();
            }
        });



    }

}
