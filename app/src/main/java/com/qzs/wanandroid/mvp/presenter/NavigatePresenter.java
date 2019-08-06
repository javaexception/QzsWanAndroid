package com.qzs.wanandroid.mvp.presenter;

import android.text.TextUtils;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.INavigateModel;
import com.qzs.wanandroid.mvp.model.IRegisterModel;
import com.qzs.wanandroid.mvp.model.impl.NavigateImpl;
import com.qzs.wanandroid.mvp.model.impl.RegisterModelImpl;
import com.qzs.wanandroid.mvp.view.INavigateView;
import com.qzs.wanandroid.mvp.view.IRegisterView;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.utils.CommonUtil;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  导航-P层
 * 创建日期：2019/7/25
 *
 */
public class NavigatePresenter extends BaseMvpPresenter<INavigateView>   {

    private INavigateModel iNavigateModel;

    public NavigatePresenter(){
        this.iNavigateModel=new NavigateImpl();

    }

    public   void   getNavigateList(){

        if (mView == null) return;
        iNavigateModel.handleNavigate(new OnLoadDatasListener<List<NavigateBean.DataBean>>() {
            @Override
            public void onSuccess(List<NavigateBean.DataBean> dataBean) {
                getView().navigateListSuccess(dataBean);

            }

            @Override
            public void onFailure(String error) {
                getView().navigateListFail();

            }
        });

    }



}
