package com.qzs.wanandroid.ui.information.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpFragment;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.presenter.FrPCenterPresenter;
import com.qzs.wanandroid.mvp.view.IFragmentPCenterView;
import com.qzs.wanandroid.ui.information.activity.ArticleDetailsActivity;
import com.qzs.wanandroid.ui.information.activity.LoginActivity;
import com.qzs.wanandroid.ui.information.activity.MyCollectActivity;
import com.qzs.wanandroid.ui.information.activity.QzsActivity;
import com.qzs.wanandroid.utils.SpUtils;

/**
 * @author qinzishuai
 * 描述：  个人中心fragment
 * 创建日期：2019/7/15
 *
 */
public class PersonalCenterFragment extends BaseMvpFragment<IFragmentPCenterView, FrPCenterPresenter> implements IFragmentPCenterView{

    private ImageView ivLoginOut;
    private LinearLayout llInfo;
    private FrameLayout flHead;
    private ImageView ivHead;
    private AppCompatTextView tvLogin;
    private LinearLayout llNickname;
    private AppCompatTextView tvUsername;

    private LinearLayout llCollect;
    private LinearLayout llMyQzs;
    private  static   String QZS="http://qinzishuai.cn";

    private LinearLayout llAbout;




    @Override
    protected FrPCenterPresenter createPresenter() {
        return new FrPCenterPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_login){
            PersonalCenterFragment.startLogin(getActivity());
        }
        if (v.getId()==R.id.ll_collect){
            PersonalCenterFragment.startCollect(getActivity());
        }
        //登出
        if (v.getId()==R.id.iv_login_out){
            mPresenter.loginOut();

        }

        if (v.getId()==R.id.ll_my_qzs){
            PersonalCenterFragment.startArticleDetail(getActivity(),"秦子帅的博客",QZS);
        }

        if (v.getId()==R.id.ll_about){
            PersonalCenterFragment.startAbout(getActivity());

        }

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_personal_center;
    }

    @Override
    public void initView() {
        llAbout =rootView. findViewById(R.id.ll_about);
        llMyQzs =rootView. findViewById(R.id.ll_my_qzs);
        ivLoginOut =rootView. findViewById(R.id.iv_login_out);
        llInfo = rootView.findViewById(R.id.ll_info);
        flHead = rootView.findViewById(R.id.fl_head);
        ivHead =rootView. findViewById(R.id.iv_head);
        tvLogin = rootView.findViewById(R.id.tv_login);
        llNickname = rootView.findViewById(R.id.ll_nickname);
        tvUsername = rootView.findViewById(R.id.tv_username);
        llCollect = rootView.findViewById(R.id.ll_collect);
        llAbout.setOnClickListener(this);
        llCollect.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        ivLoginOut.setOnClickListener(this);
        llMyQzs.setOnClickListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    private void initInfo() {
        if (SpUtils.GetConfigString("username").equals("")){
            llInfo.setVisibility(View.GONE);
            tvLogin.setVisibility(View.VISIBLE);
            llNickname.setVisibility(View.GONE);
            ivLoginOut.setVisibility(View.GONE);

        }else {
            llInfo.setVisibility(View.VISIBLE);
            llNickname.setVisibility(View.VISIBLE);
            tvLogin.setVisibility(View.GONE);
            tvUsername.setText(SpUtils.GetConfigString("username")+"");
            ivLoginOut.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static PersonalCenterFragment newInstance() {

        PersonalCenterFragment fragment = new PersonalCenterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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

    public   static   void startLogin(Context context){
        Intent intent=new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }

    public   static   void startCollect(Context context){
        Intent intent=new Intent(context, MyCollectActivity.class);
        context.startActivity(intent);

    }

    @Override
    public void onResume() {
        super.onResume();
        initInfo();
    }

    @Override
    public void loginOutSuccess(CurrencyBean.DataBean dataBean) {
        SpUtils.SetConfigString("username","");
        PersonalCenterFragment.startLogin(getActivity());
        getActivity().finish();
    }

    @Override
    public void LoginOutFail() {

    }

    public  static  void  startArticleDetail(Context context,String title,String url){

        Intent intent =new Intent(context, ArticleDetailsActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("url",url);
        context.startActivity(intent);

    }

    public  static  void  startAbout(Context context){

        Intent intent =new Intent(context, QzsActivity.class);

        context.startActivity(intent);

    }
}
