package com.qzs.wanandroid.ui.information.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.CurrencyPresenter;
import com.qzs.wanandroid.mvp.presenter.RegisterPresenter;
import com.qzs.wanandroid.mvp.view.CurrencyView;
import com.qzs.wanandroid.mvp.view.IRegisterView;
import com.qzs.wanandroid.utils.SpUtils;

/**
 * @author qinzishuai
 * 描述：  注册
 * 创建日期：2019/7/23
 *
 */
public class RegisterActivity  extends BaseMvpActivity<IRegisterView, RegisterPresenter> implements IRegisterView {
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordAgain;
    private Button btnRegister;
    private LinearLayout llLogin;



    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.ll_login){
            finish();
        }

        else if (v.getId()==R.id.btn_register){
            mPresenter.handleRegister();

        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etPasswordAgain = findViewById(R.id.et_password_again);
        btnRegister = findViewById(R.id.btn_register);
        llLogin = findViewById(R.id.ll_login);

        llLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public Dialog getLoadDialog() {
        return dialog;
    }

    @Override
    public void cancelLoadDialog() {
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }

    }

    @Override
    public void registerSuccess() {
        SpUtils.SetConfigString("username",etUsername.getText().toString());
        LoginActivity.startMain(this);

    }

    @Override
    public void registerFail() {

    }

    @Override
    public String getUser() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public String getPasswordAgain() {
        return etPasswordAgain.getText().toString().trim();
    }
}
