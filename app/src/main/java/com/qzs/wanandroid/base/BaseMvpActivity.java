package com.qzs.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.qzs.wanandroid.common.MyApplication;
import com.qzs.wanandroid.utils.DialogUtils;
import com.squareup.leakcanary.RefWatcher;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


public abstract class BaseMvpActivity<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> extends RxAppCompatActivity implements IBaseMvpView, IActivity , View.OnClickListener{

    protected P mPresenter;

    protected Dialog dialog;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ImmersionBar.with(this).init();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachMvpView((V) this);
        initImmersionBar();
        dialog = DialogUtils.createLoadingDialog(this, "请稍后...");
        initView();
        initData( savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //内存泄漏
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);//1
        refWatcher.watch(this);
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
