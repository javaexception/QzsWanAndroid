package com.qzs.wanandroid.base;


import android.app.Dialog;

public interface IBaseMvpView {
    /**
     * 获取view层的dialog
     *
     * @return retuen
     */
    Dialog getLoadDialog();

    /***
     * 关闭view层的dialog
     */
    void  cancelLoadDialog();



}
