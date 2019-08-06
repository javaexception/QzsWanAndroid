package com.qzs.wanandroid.mvp.presenter;

import com.qzs.wanandroid.base.BaseMvpPresenter;
import com.qzs.wanandroid.base.OnLoadDatasListener;
import com.qzs.wanandroid.bean.CurrencyBean;
import com.qzs.wanandroid.mvp.model.ICollectModel;
import com.qzs.wanandroid.mvp.model.IFrHomeModel;
import com.qzs.wanandroid.mvp.model.IMyCollectModel;
import com.qzs.wanandroid.mvp.model.impl.CollectModelImpl;
import com.qzs.wanandroid.mvp.model.impl.FrHomeModelImpl;
import com.qzs.wanandroid.mvp.model.impl.MyCollectModelImpl;
import com.qzs.wanandroid.mvp.view.IFragmentHomeView;
import com.qzs.wanandroid.mvp.view.IMyCollectView;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;

/**
 * @author qinzishuai
 * 描述：  我的收藏-p层
 * 创建日期：2019/7/31
 *
 */
public class MyCollectPresenter extends BaseMvpPresenter<IMyCollectView>   {

    private IMyCollectModel iMyCollectModel;

    private ICollectModel  iCollectModel;

    public  MyCollectPresenter(){
        this.iMyCollectModel=new MyCollectModelImpl();
        this.iCollectModel=new CollectModelImpl();
    }

    public  void  getMyCollectList(final String type){
        if (mView == null) return;
        iMyCollectModel.handleMyCollectList(mView.getPage(), new OnLoadDatasListener<MyCollectBean.DataBean>() {
            @Override
            public void onSuccess(MyCollectBean.DataBean dataBean) {
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

    public  void  cancelCollect(){

        if (mView == null) return;
        getView().getLoadDialog().show();
       iCollectModel.handleCancelCollect(mView.getCollectId()+"", new OnLoadDatasListener<CurrencyBean.DataBean>() {
           @Override
           public void onSuccess(CurrencyBean.DataBean dataBean) {
               getView().cancelLoadDialog();
               getView().CancelCollectSuccess();
           }

           @Override
           public void onFailure(String error) {
               getView().cancelLoadDialog();
               getView().CancelCollectFail();
           }
       });
    }


}
