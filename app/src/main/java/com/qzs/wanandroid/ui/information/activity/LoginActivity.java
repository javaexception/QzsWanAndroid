package com.qzs.wanandroid.ui.information.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.common.MainActivity;
import com.qzs.wanandroid.mvp.presenter.LoginPresenter;
import com.qzs.wanandroid.mvp.view.ILoginView;
import com.qzs.wanandroid.utils.SpUtils;

/**
 * @author qinzishuai
 * 描述：  登录
 * 创建日期：2019/7/23
 *
 */
public class LoginActivity  extends BaseMvpActivity<ILoginView, LoginPresenter> implements ILoginView{

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private AppCompatTextView tvRegister;



    @Override
    protected LoginPresenter createPresenter() {

        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_login){
            mPresenter.handleLogin();
        }
        else if (v.getId()==R.id.tv_register){
            LoginActivity.startRegister(this);
        }

    }

    @Override
    public int getLayout() {

        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
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
    public void loginSuccess() {
        SpUtils.SetConfigString("username",etUsername.getText().toString());
        LoginActivity.startMain(this);

    }

    @Override
    public void loginFail() {

    }

    @Override
    public String getUser() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    public static   void   startMain(Context context){
        Intent intent=new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

    public static   void   startRegister(Context context){
        Intent intent=new Intent(context, RegisterActivity.class);
        context.startActivity(intent);

    }
}
