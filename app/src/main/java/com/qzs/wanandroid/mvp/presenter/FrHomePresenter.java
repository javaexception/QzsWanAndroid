package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.mvp.model.IBannerModel;
import com.qzs.wanandroid.mvp.model.impl.BannerModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentHomeView;
import com.qzs.wanandroid.ui.information.bean.BannerBean;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.impl.FrHomeModelImpl;

import java.util.List;

/**
 * @author qinzishuai
 * 描述：  首页fragment 的P层
 * 创建日期：2019/7/20
 *
 */
public class FrHomePresenter extends BaseMvpPresenter<IFragmentHomeView>   {

  private IFrHomeModel iFrHomeModel;

  private IBannerModel  iBannerModel;



    public FrHomePresenter() {

        this.iFrHomeModel = new FrHomeModelImpl();
        this.iBannerModel=new BannerModelImpl();
    }

    /***
     * 获取首页list
     */
    public  void  getHomeList(final String type){

        if (mView == null) return;

        iFrHomeModel.handleHomeList(mView.getPage(), new OnLoadDatasListener<MainListBean.DataBean>() {
            @Override
            public void onSuccess(MainListBean.DataBean dataBean) {

                    mView.cancelLoadDialog();
                getView().getMainListSuccess(dataBean,type);

            }

            @Override
            public void onFailure(String error) {
                if (type.equals("首次加载")){
                    mView.cancelLoadDialog();
                }
                getView().getMainListFail();

            }
        });


    }


    public  void  getBanner(){
        if (mView == null) return;
        iBannerModel.handleBanner(new OnLoadDatasListener<List<BannerBean.DataBean>>() {
            @Override
            public void onSuccess(List<BannerBean.DataBean> dataBeans) {
                mView.getBannerSuccess(dataBeans);
            }

            @Override
            public void onFailure(String error) {
                mView.getBannerFail();

            }
        });



    }
}
