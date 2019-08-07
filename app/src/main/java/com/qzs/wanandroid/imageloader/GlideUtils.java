package com.qzs.wanandroid.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.common.MyApplication;
import com.qzs.wanandroid.utils.Utils;

import jp.wasabeef.blurry.Blurry;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * @作者 qinzishuai
 * @创建日期 2019/03/06
 */

public class GlideUtils {
    /**
     * Load image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     */
//https://blog.csdn.net/zhangyiminsunshine/article/details/78051435
    /*
     *加载图片(默认)
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .dontAnimate()
            //    .placeholder(R.mipmap.ic_zhanwei_banner) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                ;
        Glide.with(MyApplication.getContext()).load(url).apply(options).into(imageView);
    }

    /*
     *加载图片(默认)
     */
    public static void loadlocalImage(Context context, int res, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .dontAnimate()
                //    .placeholder(R.mipmap.ic_zhanwei_banner) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                ;
        Glide.with(MyApplication.getContext()).load(res).apply(options).into(imageView);
    }
    /**
     * Load circle image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     */
    /*
     *加载圆形图片
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
               // .placeholder(R.color.white)
           //     .error(R.mipmap.ic_zhanwei_head)
                //.priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getContext()).load(url).apply(options).into(imageView);
    }

    /**
     * Load round circle image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     */
    /*
     *加载圆角图片
     */
    public static void loadRoundCircleImage(Context context, String url, ImageView imageView,int radius) {

        RequestOptions options = new RequestOptions()
          //      .centerCrop()
                .circleCrop()//设置圆形
            //    .placeholder(R.color.white)
             //   .error(R.mipmap.ic_zhanwei_banner)
                //.priority(Priority.HIGH)
//                .skipMemoryCache(FA)
                .bitmapTransform(new RoundedCornersTransformation(radius, 0, RoundedCornersTransformation.CornerType.ALL))
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context).load(url).apply(options).into(imageView);

    }

    /**
     * Load cust round circle image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     * @param type      the type
     */
    /*
     *加载圆角图片-指定任意部分圆角（图片上、下、左、右四个角度任意定义）
     */
    public static void loadCustRoundCircleImage(Context context, String url, ImageView imageView, RoundedCornersTransformation.CornerType type) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
             //   .placeholder(R.color.white)
            //    .error(R.color.white)
                //.priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation(45, 0, type))
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context).load(url).apply(options).into(imageView);
    }

    /**
     * Load blur image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     * @param blur      the blur
     */
    /*
     *加载模糊图片（自定义透明度）
     */
    public static void loadBlurImage(Context context, String url, ImageView imageView, int blur) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
              //  .placeholder(R.color.white)
              //  .error(R.color.white)
                //.priority(Priority.HIGH)
                .bitmapTransform(new BlurTransformation(blur))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(options).into(imageView);
    }

    /**
     * Load blur image.
     *
     * @param context   the context
     * @param imageView the image view
     * @param blur      the blur
     */
    /*
     *加载模糊图片（自定义透明度）
     */
    public static void loadLocalBlurImage(Context context, int res, ImageView imageView, int blur) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .dontAnimate()
                  .placeholder(R.mipmap.ic_home_search_bg)
                //  .error(R.color.white)
                //.priority(Priority.HIGH)
                .bitmapTransform(new BlurTransformation(blur))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(res).apply(options).into(imageView);
    }


    public static void loadBlurry(final ImageView imageView, Object o) {
        if (imageView == null) {
            return;
        }

        Drawable drawable = imageView.getDrawable();

        Glide.with(imageView.getContext())
                .load(o)
                .apply(new RequestOptions().placeholder(drawable).error(drawable).centerCrop())
                .transition(new DrawableTransitionOptions().crossFade())
                .into(new DrawableImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                        Blurry.with(imageView.getContext()).from(bitmap).into(imageView);
                    }
                });
    }

    /**
     * Load black image.
     *
     * @param context   the context
     * @param url       the url
     * @param imageView the image view
     */
    /*
     *加载灰度(黑白)图片（自定义透明度）
     */
    public static void loadBlackImage(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .dontAnimate()
               // .placeholder(R.color.white)
              //  .error(R.color.white)
              //  .priority(Priority.HIGH)
                .bitmapTransform(new GrayscaleTransformation())
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(url).apply(options).into(imageView);
    }

    /**
     * Dip 2 px int.
     *
     * @param context the context
     * @param dp      the dp
     * @return the int
     */
    public static int dip2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 加载第四秒的帧数作为封面
     *  url就是视频的地址
     */
    public static void loadCover(Context context, String url,ImageView imageView) {

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context)
                .setDefaultRequestOptions(
                        new RequestOptions()
                                .frame(1000000)
                                .centerCrop()
                        //        .error(R.mipmap.ic_zhanwei_banner)//可以忽略
                              //  .placeholder(R.mipmap.ppppp)//可以忽略
                )
                .load(url)
                .into(imageView);
    }

}
