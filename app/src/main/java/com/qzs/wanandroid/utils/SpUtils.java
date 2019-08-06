package com.qzs.wanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qzs.wanandroid.common.MyApplication;

import java.util.ArrayList;
import java.util.List;


public class SpUtils {
    private static final String spFileName = "sputils";

    public static boolean SetConfigString(String keyanme, String keyvalue) {

        try
        {
            //实例化SharedPreferences对象（第一步）
            SharedPreferences mySharedPreferences= MyApplication.getContext().getSharedPreferences(spFileName, Activity.MODE_PRIVATE);
            //实例化SharedPreferences.Editor对象（第二步）
            SharedPreferences.Editor editor = mySharedPreferences.edit();
            //用putString的方法保存数据
            editor.putString(keyanme, keyvalue);
            //提交当前数据
            editor.commit();
            //使用toast信息提示框提示成功写入数据
            String strout = "数据成功写入SharedPreferences！"+"keyanme----"+keyanme+"----keyvalue---"+keyvalue;
            LogUtils.d(strout);
            //Toast.makeText(context,strout, Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

            return false;
        }
        return true;
    }

    public static String GetConfigString(String keyanme)
    {
        String resultvalue="";
        try
        {
            SharedPreferences sharedPreferences= MyApplication.getContext().getSharedPreferences(spFileName, Activity.MODE_PRIVATE);
            // 使用getString方法获得value，注意第2个参数是value的默认值
            resultvalue =sharedPreferences.getString(keyanme, "");
            //使用toast信息提示框显示信息
       //     String strout = "数据成功读取SharedPreferences！"+"\n"+keyanme+ " " +  resultvalue;
     //       LogUtils.d(strout);
            //Toast.makeText(context, strout,Toast.LENGTH_LONG).show();
            LogUtils.d("我没异常----我取数据"+keyanme+" -------"+resultvalue);
        }
        catch(Exception ex)
        {
            LogUtils.d("我异常了");
            ex.printStackTrace();

            return "";
        }

        return resultvalue;
    }


    public static Boolean getBoolean(String strKey,
                                     Boolean strDefault) {
        SharedPreferences setPreferences = MyApplication.getContext().getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        Boolean result = setPreferences.getBoolean(strKey, strDefault);
        return result;
    }


    public static void putBoolean( String strKey,
                                  Boolean strData) {
        SharedPreferences activityPreferences = MyApplication.getContext().getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(strKey, strData);
        editor.commit();
    }


    /**
     *
     * @param keyanme
     * @param keyvalue
     */
    public  static void SetList(String keyanme, List<String> keyvalue) {

        try
        {
            Gson gson=new Gson();
            //实例化SharedPreferences对象（第一步）
            SharedPreferences mySharedPreferences= MyApplication.getContext().getSharedPreferences(spFileName, Activity.MODE_PRIVATE);
            //实例化SharedPreferences.Editor对象（第二步）
            SharedPreferences.Editor editor = mySharedPreferences.edit();

            String  str=gson.toJson(keyvalue);
            //用putString的方法保存数据
            editor.putString(keyanme, str);
            //提交当前数据
            editor.commit();
            //使用toast信息提示框提示成功写入数据
            String strout = "数据成功写入SharedPreferences！"+keyvalue;
            LogUtils.d(strout);
            //Toast.makeText(context,strout, Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();


        }

    }




    public  static List<String> getList(String keyanme,List<String> phoneList) {
        phoneList=new ArrayList<>();
        phoneList.clear();


          List<String>  list=new ArrayList<>();
        try
        {
            String resultvalue="";
            Gson gson=new Gson();
            //实例化SharedPreferences对象（第一步）
            SharedPreferences mySharedPreferences= MyApplication.getContext().getSharedPreferences(spFileName, Activity.MODE_PRIVATE);
            //实例化SharedPreferences.Editor对象（第二步）

            resultvalue=mySharedPreferences.getString(keyanme, "");

            list=gson.fromJson(resultvalue,new TypeToken<List<String>>(){}.getType());

            //使用toast信息提示框提示成功写入数据
            String strout = "数据成功写入SharedPreferences！"+resultvalue;
            LogUtils.d(strout);
            //Toast.makeText(context,strout, Toast.LENGTH_LONG).show();
            phoneList=list;
            return phoneList;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return  null;

        }

    }




}
