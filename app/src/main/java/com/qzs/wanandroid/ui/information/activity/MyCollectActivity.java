package com.qzs.wanandroid.ui.information.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.ImmersionBar;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.CurrencyPresenter;
import com.qzs.wanandroid.mvp.presenter.MyCollectPresenter;
import com.qzs.wanandroid.mvp.view.CurrencyView;
import com.qzs.wanandroid.mvp.view.IMyCollectView;
import com.qzs.wanandroid.ui.information.adapter.HomeAdapter;
import com.qzs.wanandroid.ui.information.adapter.MyCollectAdapter;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.bean.MyCollectBean;
import com.qzs.wanandroid.ui.information.fragment.HomeFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/***
 * 收藏
 */
public class MyCollectActivity extends BaseMvpActivity<IMyCollectView, MyCollectPresenter> implements  IMyCollectView {

    private Toolbar toolbar;
    private ImageView ivToolbarLeft;
    private AppCompatTextView tvTitle;
    private SmartRefreshLayout srfCollectRefresh;
    private RecyclerView rvCollect;
    private List<MyCollectBean.DataBean.DatasBean> collectList=new ArrayList<>();

    /**
     * 当前页数
     */
    private  int currPage=0;
    /***
     * 总页数
     */
    private   int mPageCount=0;

    private MyCollectAdapter myCollectAdapter;

    private String  mCollectId="";

    private  int mPosition;


    @Override
    protected MyCollectPresenter createPresenter() {
        return new MyCollectPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.iv_toolbar_left){
            finish();
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_my_collect;
    }

    @Override
    public void initView() {
        toolbar = findViewById(R.id.toolbar);
        ivToolbarLeft = findViewById(R.id.iv_toolbar_left);
        tvTitle = findViewById(R.id.tv_title);
        srfCollectRefresh = findViewById(R.id.srf_collect_refresh);
        rvCollect = findViewById(R.id.rv_collect);

        ivToolbarLeft.setOnClickListener(this);

        tvTitle.setText("我的收藏");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getMyCollectList("下拉刷新");

        ImmersionBar.with(this).titleBar(R.id.toolbar).init();
        handleLoadData();
    }

    @Override
    public Dialog getLoadDialog() {
        return dialog;
    }

    @Override
    public void cancelLoadDialog() {
        if (dialog!=null&&dialog.isShowing()){
            dialog.cancel();
        }

    }

    @Override
    public void getMainListSuccess(MyCollectBean.DataBean dataBean, String type) {

        currPage=dataBean.getCurPage();
        mPageCount=dataBean.getPageCount();
        if (type.equals("下拉刷新")){

            collectList.clear();
            collectList.addAll(dataBean.getDatas());

            if (myCollectAdapter==null){

                rvCollect.setLayoutManager(new LinearLayoutManager(this));
                myCollectAdapter = new MyCollectAdapter(this,R.layout.item_my_collect,collectList);

                myCollectAdapter.setHasStableIds(true);
                myCollectAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                myCollectAdapter.isFirstOnly(false);
                rvCollect.setAdapter(myCollectAdapter);

                myCollectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HomeFragment.startArticleDetail(MyCollectActivity.this,collectList.get(position).getTitle(),collectList.get(position).getLink()+"");
                    }
                });

                myCollectAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        SwipeMenuLayout swipeMenuLayout= (SwipeMenuLayout) adapter.getViewByPosition(rvCollect, position, R.id.SwipeMenuLayout);
                        if (view.getId()==R.id.btnDelete){
                            swipeMenuLayout.quickClose();
                            mPosition=position;
                            mCollectId=collectList.get(position).getOriginId()+"";
                            mPresenter.cancelCollect();

                        }
                    }
                });


            }else {
                myCollectAdapter.refresh(dataBean);

            }
            srfCollectRefresh.finishRefresh();

        }

        else if (type.equals("上拉加载")){
            if (myCollectAdapter == null) {
                srfCollectRefresh.finishLoadMoreWithNoMoreData();
                return;
            }
            final List<MyCollectBean.DataBean.DatasBean> loadList = new ArrayList<>();
            loadList.clear();
            loadList.addAll(dataBean.getDatas());
            myCollectAdapter.Load(loadList);

        }
        srfCollectRefresh.finishLoadMore(/*,false*/);//不传时间则立即停止刷新    传入false表示加载失败

    }

    @Override
    public void getMainListFail() {

    }

    @Override
    public int getPage() {
        return currPage;
    }

    @Override
    public String getCollectId() {
        return mCollectId;
    }

    @Override
    public void CancelCollectSuccess() {
        collectList.remove(mPosition);
        myCollectAdapter.notifyDataSetChanged();

    }

    @Override
    public void CancelCollectFail() {

    }


    /***
     * 刷新与上拉
     */
    private void handleLoadData() {

        srfCollectRefresh.setEnableLoadMore(true);

        srfCollectRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                currPage=0;
                mPresenter.getMyCollectList("下拉刷新");

            }
        });

        srfCollectRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //无数据了
                if (currPage>=mPageCount){
                    srfCollectRefresh.finishLoadMoreWithNoMoreData();
                    return;
                }
                mPresenter.getMyCollectList("上拉加载");

            }
        });


    }
}
