package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
/**
 * @author qinzishuai
 * 描述：  登录
 * 创建日期：2019/7/23
 *
 */
public interface ILoginView extends IBaseMvpView {


    /***
     * 登录成功
     */
    void loginSuccess();

    /***
     * 登录失败
     */
    void loginFail();


    /***
     * 获取用户名
     */
    String  getUser();

    /***
     * 获取密码
     * @return
     */
    String  getPassword();



}
