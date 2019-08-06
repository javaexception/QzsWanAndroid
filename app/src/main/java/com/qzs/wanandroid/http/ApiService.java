package com.qzs.wanandroid.http;



import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.ui.information.bean.BannerBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.ui.information.bean.ProjectListBean;
import com.qzs.wanandroid.ui.information.bean.ProjectTitleBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author qinzishuai
 * 描述：  接口
 * 创建日期：2019/7/12
 *
 */
public interface ApiService {


    String BASE_URL = "https://www.wanandroid.com/";

    //网络请求时长
    int HTTP_TIME =0;


    /***
     * 获取首页列表数据
     * @param page
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseResponse<MainListBean .DataBean>> getHomeList(@Path("page") int page);

    /***
     * 获取项目模块的title
     * @return
     */
    @GET("project/tree/json")
    Observable<BaseResponse<List<ProjectTitleBean.DataBean>>> getProjectTitle();

    /***
     * 获取项目模块的内容
     * @param page
     * @param id
     * @return
     */
    @GET("project/list/{page}/json")
    Observable<BaseResponse<ProjectListBean.DataBean>> getProjectList(@Path("page") int page, @Query("cid") String id);


    /***
     * 登录
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponse<CurrencyBean.DataBean>> login(@Field("username") String username, @Field("password") String password);


    /****
     * 站内收藏
     * @param id
     * @return
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResponse<CurrencyBean.DataBean>> collectIn(@Path("id") String id);
    /****
     * 取消收藏
     * @param id
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResponse<CurrencyBean.DataBean>> cancelCollect(@Path("id") String id);


    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseResponse<CurrencyBean.DataBean>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);


    /***
     * 获取导航lsit
     * @return
     */
    @GET("navi/json")
    Observable<BaseResponse<List<NavigateBean.DataBean>>> getNavigateList();



    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Observable<BaseResponse<MainListBean.DataBean>> searchDetail(@Path("page") int page,@Field("k") String k);


    /***
     * 我的收藏
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    Observable<BaseResponse<MyCollectBean.DataBean>> getMyCollect(@Path("page") int page);



    /***
     * 首页banner
     * @return
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerBean.DataBean>>> getBanner();


    /***
     * 登出
     * @return
     */
    @GET("user/logout/json")
    Observable<BaseResponse<CurrencyBean.DataBean>> loginOut();
}
