package com.qzs.wanandroid.common;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.MainPresenter;
import com.qzs.wanandroid.mvp.view.IMainView;
import com.qzs.wanandroid.ui.information.fragment.HomeFragment;
import com.qzs.wanandroid.ui.information.fragment.NavigateFragment;
import com.qzs.wanandroid.ui.information.fragment.PersonalCenterFragment;
import com.qzs.wanandroid.ui.information.fragment.ProjectFragment;
import com.qzs.wanandroid.utils.LogUtils;
import com.qzs.wanandroid.utils.SpUtils;

/**
 * @author qinzishuai
 * 描述：  主页
 * 创建日期：2019/7/15
 *
 */
public class MainActivity extends BaseMvpActivity<IMainView, MainPresenter> implements BottomNavigationBar.OnTabSelectedListener ,IMainView{


    private FrameLayout llContent;

    private BottomNavigationBar bottomNavigationBar;

    // Fragment管理器，和执行器
    private FragmentManager mManager;

    private FragmentTransaction mTransaction;

    private  HomeFragment homeFragment;

    private PersonalCenterFragment personalCenterFragment;

    private ProjectFragment projecetFragment;

    private NavigateFragment navigateFragment;

    private LinearLayout flashView;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        flashView = findViewById(R.id.flash_view);
        llContent = findViewById(R.id.ll_content);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        // TODO 设置模式
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        // TODO 设置背景色样式
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBarBackgroundColor(R.color.background_gray_color);

        flashView.setVisibility(View.VISIBLE);
        flashView.postDelayed(new Runnable() {
            @Override
            public void run() {
                flashView.setVisibility(View.GONE);
            }
        }, 1500);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mManager =getSupportFragmentManager();
        initBottomNavigationBar();
    }


    private void initBottomNavigationBar() {

        /**
         *  new BottomNavigationItem(R.mipmap.tab_home_pressed,"首页") ,选中的图标，文字
         *  setActiveColorResource：选中的颜色
         *  setInactiveIconResource：未选中的图标
         *  setInActiveColorResource：未选中的颜色
         */


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_main_home1, "首页").setActiveColorResource(R.color.txt_select).setInactiveIconResource(R.mipmap.ic_main_home2).setInActiveColorResource(R.color.txt_unselect))
                .addItem(new BottomNavigationItem(R.mipmap.ic_main_project1, "项目").setActiveColorResource(R.color.txt_select).setInactiveIconResource(R.mipmap.ic_main_project2).setInActiveColorResource(R.color.txt_unselect))
                .addItem(new BottomNavigationItem(R.mipmap.ic_main_navigate1, "导航").setActiveColorResource(R.color.txt_select).setInactiveIconResource(R.mipmap.ic_main_navigate2).setInActiveColorResource(R.color.txt_unselect))
                .addItem(new BottomNavigationItem(R.mipmap.ic_main_me1, "我的").setActiveColorResource(R.color.txt_select).setInactiveIconResource(R.mipmap.ic_main_me2).setInActiveColorResource(R.color.txt_unselect))
                .initialise();
        // mShapeBadgeItem.hide();

        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.selectTab(0);
    }



    @Override
    public void onTabSelected(int position) {
        //开启事务
        mTransaction = mManager.beginTransaction();
        hideFragment(mTransaction);


        /**
         * fragment 用 add + show + hide 方式
         * 只有第一次切换会创建fragment，再次切换不创建
         *
         * fragment 用 replace 方式
         * 每次切换都会重新创建
         *
         */
        switch (position){
            case 0:   // 首页

                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance();
                    mTransaction.add(R.id.ll_content,
                            homeFragment);
                } else {
                    mTransaction.show(homeFragment);
                }
                break;
            case 1:    // 项目
                if (projecetFragment == null) {
                    projecetFragment =  ProjectFragment.newInstance();
                    mTransaction.add(R.id.ll_content,
                            projecetFragment);
                } else {
                    mTransaction.show(projecetFragment);
                }
                break;
            case 2:  // 导航
                if (navigateFragment == null) {
                    navigateFragment = NavigateFragment.newInstance();
                    mTransaction.add(R.id.ll_content,
                            navigateFragment);
                } else {
                    mTransaction.show(navigateFragment);
                }
                break;
            case 3:  // 我的
                if (personalCenterFragment == null) {
                    personalCenterFragment = PersonalCenterFragment.newInstance();
                    mTransaction.add(R.id.ll_content,
                            personalCenterFragment);
                } else {
                    mTransaction.show(personalCenterFragment);
                }
                break;
        }
        // 事务提交
        mTransaction.commit();
        //  mTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * 隐藏当前fragment
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction){
        if (homeFragment != null){
            transaction.hide(homeFragment);
        }

        if (personalCenterFragment != null){
            transaction.hide(personalCenterFragment);
        }

        if (projecetFragment!=null){
            transaction.hide(projecetFragment);
        }
        if (navigateFragment!=null){
            transaction.hide(navigateFragment);
        }



    }

    @Override
    public Dialog getLoadDialog() {
        return null;
    }

    @Override
    public void cancelLoadDialog() {

    }


}
