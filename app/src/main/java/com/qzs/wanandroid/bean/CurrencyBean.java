package com.qzs.wanandroid.bean;

/**
 * @author qinzishuai
 * 描述：  通用bean
 * 创建日期：2019/4/26
 *
 */
public class CurrencyBean<BaseResponse>{


    /**
     * msg : success
     * code : 0
     * data : {}
     */

    private String errorMsg;
    private int errorCode;
    private DataBean data;

    public String getMsg() {
        return errorMsg;
    }

    public void setMsg(String msg) {
        this.errorMsg = msg;
    }

    public int getCode() {
        return errorCode;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean  {
    }
}
