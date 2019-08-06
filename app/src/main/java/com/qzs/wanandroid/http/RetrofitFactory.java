package com.qzs.wanandroid.http;



import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.BannerBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private final ApiService mApiService;

    private static RetrofitFactory mRetrofitFactory;

    private RetrofitFactory() {
        //创建日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//设定日志级别
        //创建OkHttpClient
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(ApiService.HTTP_TIME, TimeUnit.SECONDS)
                .readTimeout(ApiService.HTTP_TIME, TimeUnit.SECONDS)
                .writeTimeout(ApiService.HTTP_TIME, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)//添加拦截器
                .addInterceptor(new ReceivedCookiesInterceptor())
                .addInterceptor(new AddCookiesInterceptor())
                .build();

        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava2转换器
                .client(mOkHttpClient)
                .build();

        //创建接口实现类
        mApiService = retrofit.create(ApiService.class);

    }




    public static RetrofitFactory getInstence() {
        if (mRetrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null)
                    mRetrofitFactory = new RetrofitFactory();
            }
        }
        return mRetrofitFactory;
    }

    public ApiService API() {
        return mApiService;
    }

    public ObservableTransformer threadTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public void getHomeList(int page, BaseObserver<MainListBean.DataBean> scheduler) {
        API()
                .getHomeList(page)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }



    public void getProjectTitle( BaseObserver<List<ProjectTitleBean.DataBean>> scheduler) {
        API()
                .getProjectTitle()
                .compose(threadTransformer())
                .subscribe(scheduler);
    }



    public void getProjectList(int page, String  id, BaseObserver<ProjectListBean.DataBean> scheduler) {
        API()
                .getProjectList(page,id)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }



    public void login(String username, String  password, BaseObserver<CurrencyBean.DataBean> scheduler) {
        API()
                .login(username,password)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }

    public void collectIn(String id, BaseObserver<CurrencyBean.DataBean> scheduler) {
        API()
                .collectIn(id)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }

    public void register(String username, String  password,String repassword ,BaseObserver<CurrencyBean.DataBean> scheduler) {
        API()
                .register(username,password,repassword)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }

    public void navigateList(BaseObserver<List<NavigateBean.DataBean>> scheduler) {
        API()
                .getNavigateList()
                .compose(threadTransformer())
                .subscribe(scheduler);
    }



    public void searchDetail(int page,String k,BaseObserver<MainListBean.DataBean> scheduler) {
        API()
                .searchDetail(page,k)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }

    public void getMyCollect(int page, BaseObserver<MyCollectBean.DataBean> scheduler) {
        API()
                .getMyCollect(page)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }


    public void cancelCollect(String id, BaseObserver<CurrencyBean.DataBean> scheduler) {
        API()
                .cancelCollect(id)
                .compose(threadTransformer())
                .subscribe(scheduler);
    }



    public void getBanner( BaseObserver<List<BannerBean.DataBean>> scheduler) {
        API()
                .getBanner()
                .compose(threadTransformer())
                .subscribe(scheduler);
    }


    public void loginOut( BaseObserver<CurrencyBean.DataBean> scheduler) {
        API()
                .loginOut()
                .compose(threadTransformer())
                .subscribe(scheduler);
    }
}
