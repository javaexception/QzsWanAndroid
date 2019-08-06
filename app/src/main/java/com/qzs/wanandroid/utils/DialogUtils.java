package com.qzs.wanandroid.utils;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qzs.wanandroid.R;


public class DialogUtils {

    /**
     * 获取一个类似加载的对话框
     *
     * @param context 上下文
     * @param msg     文字说明
     * @return 对话框的对象
     */
    public static Dialog createLoadingDialog(Context context, String msg) {
		/*
         * 获得view填充器对象
		 */
        LayoutInflater inflater = LayoutInflater.from(context);
        /*
         * 得到加载view
         */
        View v = inflater.inflate(R.layout.loading_dialog, null);
        TextView tipTextView =  v.findViewById(R.id.tipTextView);// 提示文字
        if (msg != null && !msg.equals("")) {
            tipTextView.setText(msg);// 设置加载信息
        }

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setCancelable(true);// 可以用“返回键”取消
        loadingDialog.setCanceledOnTouchOutside(false);//
        loadingDialog.setContentView(v);// 设置布局

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = (int) (dm.widthPixels*0.3);
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        loadingDialog.getWindow().setLayout(width ,height);

        return loadingDialog;
    }
}
