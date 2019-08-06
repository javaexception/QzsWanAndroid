package com.qzs.wanandroid.mvp.view;

import com.qzs.wanandroid.base.IBaseMvpView;

/**
 * @author qinzishuai
 * 描述：  注册
 * 创建日期：2019/7/23
 *
 */
public interface IRegisterView extends IBaseMvpView {


    /***
     * 注册成功
     */
    void registerSuccess();

    /***
     * 登录失败
     */
    void registerFail();


    /***
     * 获取用户名
     */
    String  getUser();

    /***
     * 获取密码
     * @return
     */
    String  getPassword();

    /***
     * 获取再次输入的密码
     * @return
     */
    String  getPasswordAgain();

}
