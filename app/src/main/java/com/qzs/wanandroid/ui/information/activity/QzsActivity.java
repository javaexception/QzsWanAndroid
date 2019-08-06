package com.qzs.wanandroid.ui.information.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.CurrencyPresenter;
import com.qzs.wanandroid.mvp.view.CurrencyView;

public class QzsActivity  extends BaseMvpActivity<CurrencyView, CurrencyPresenter> {
    private ImageView ivToolbarLeft;
    private AppCompatTextView tvTitle;


    @Override
    protected CurrencyPresenter createPresenter() {
        return new CurrencyPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.iv_toolbar_left){
            finish();
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_qzs;
    }

    @Override
    public void initView() {

        ivToolbarLeft = findViewById(R.id.iv_toolbar_left);
        tvTitle = findViewById(R.id.tv_title);
        ivToolbarLeft.setOnClickListener(this);
        tvTitle.setText("关于我");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ImmersionBar.with(this).titleBar(R.id.toolbar).init();
    }

    @Override
    public Dialog getLoadDialog() {
        return null;
    }

    @Override
    public void cancelLoadDialog() {

    }
}
