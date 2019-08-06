package com.qzs.wanandroid.mvp.presenter;

import android.text.TextUtils;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.ILoginModel;
import com.qzs.wanandroid.mvp.model.IRegisterModel;
import com.qzs.wanandroid.mvp.model.impl.LoginModelImpl;
import com.qzs.wanandroid.mvp.model.impl.RegisterModelImpl;
import com.qzs.wanandroid.mvp.view.ILoginView;
import com.qzs.wanandroid.mvp.view.IRegisterView;
import com.qzs.wanandroid.utils.CommonUtil;
import com.qzs.wanandroid.utils.LogUtils;

/**
 * @author qinzishuai
 * 描述：   注册
 * 创建日期：2019/7/23
 *
 */
public class RegisterPresenter extends BaseMvpPresenter<IRegisterView>   {

  private IRegisterModel iRegisterModel;
    public RegisterPresenter(){
        this.iRegisterModel=new RegisterModelImpl();

    }


    public  void handleRegister(){
        if (mView == null) return;

        if (TextUtils.isEmpty(mView.getUser()) || TextUtils.isEmpty(mView.getPassword())) {
            CommonUtil.showToast("用户名或密码不能为空");
            return;
        }

        getView().getLoadDialog().show();
        iRegisterModel.handleRegister(mView.getUser(), mView.getPassword(), mView.getPasswordAgain(), new OnLoadDatasListener<CurrencyBean.DataBean>() {
            @Override
            public void onSuccess(CurrencyBean.DataBean dataBean) {
                getView().cancelLoadDialog();
                getView().registerSuccess();

            }

            @Override
            public void onFailure(String error) {
                getView().cancelLoadDialog();
                getView().registerFail();
            }
        });
    }


}
