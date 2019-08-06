package com.qzs.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.common.MyApplication;
import com.qzs.wanandroid.utils.DialogUtils;
import com.qzs.wanandroid.utils.HideUtil;
import com.squareup.leakcanary.RefWatcher;
import com.trello.rxlifecycle2.components.support.RxFragment;

public  abstract  class BaseMvpFragment<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> extends RxFragment  implements IBaseMvpView, IFragment, View.OnClickListener{

    protected P mPresenter;

    protected View rootView;// 缓存Fragment view
    protected Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), null);
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        //  unbinder = ButterKnife.bind(this, rootView);
        if (rootView instanceof ViewGroup) {
            HideUtil.init(getActivity(), (ViewGroup) rootView);//初始化触摸关闭软键盘
        }

        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachMvpView((V) this);

        dialog = DialogUtils.createLoadingDialog(getActivity(), "请稍后...");

        initImmersionBar();
        initView();
        initData(savedInstanceState);
        return rootView;
    }


    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());//1
        refWatcher.watch(this);
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this).init();
    }

}
