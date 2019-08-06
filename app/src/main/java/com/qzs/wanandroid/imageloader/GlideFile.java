package com.qzs.wanandroid.imageloader;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class GlideFile {

    /**
     * 加载网络图片
     */
    public  static  File  loadIntentPic (Context context,String imgUrl) throws ExecutionException, InterruptedException {

        File file = Glide.with(context)
                .load(imgUrl)
                .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .get();

        return file;
    }
}
