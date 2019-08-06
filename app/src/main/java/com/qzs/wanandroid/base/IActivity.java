package com.qzs.wanandroid.base;

import android.os.Bundle;

/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/12
 *
 */
public interface IActivity {

    int getLayout();

    void initView();

    void initData(Bundle savedInstanceState);
}
