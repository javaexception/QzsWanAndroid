package com.qzs.wanandroid.ui.information.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.CurrencyPresenter;
import com.qzs.wanandroid.mvp.presenter.SearchDetailPresenter;
import com.qzs.wanandroid.mvp.view.CurrencyView;
import com.qzs.wanandroid.mvp.view.ISearchDetailView;
import com.qzs.wanandroid.ui.information.adapter.HomeAdapter;
import com.qzs.wanandroid.ui.information.bean.MainListBean;
import com.qzs.wanandroid.ui.information.fragment.HomeFragment;
import com.qzs.wanandroid.utils.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class SearchDetailActivity extends BaseMvpActivity<ISearchDetailView, SearchDetailPresenter> implements ISearchDetailView {

    private EditText edtSearch;

    private AppCompatTextView tvClose;

    private LinearLayout llEmpty;

    private SmartRefreshLayout srfSearchRefresh;

    private RecyclerView rvSearch;

    private InputMethodManager manager;//输入法管理器
    /**
     * 当前页数
     */
    private  int currPage=0;
    /***
     * 总页数
     */
    private   int mPageCount=0;

    private HomeAdapter homeAdapter;

    private List<MainListBean.DataBean.DatasBean> searchList=new ArrayList<>();
    @Override
    protected SearchDetailPresenter createPresenter() {

      return  new SearchDetailPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_close){
           finish();
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_search_detail;
    }

    @Override
    public void initView() {
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        edtSearch = findViewById(R.id.edt_search);
        tvClose = findViewById(R.id.tv_close);
        llEmpty = findViewById(R.id.ll_empty);
        srfSearchRefresh = findViewById(R.id.srf_search_refresh);
        rvSearch = findViewById(R.id.rv_search);

        tvClose.setOnClickListener(this);

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        hanldeEtOnKey();
        handleLoadData();
    }

    private void handleLoadData() {
        srfSearchRefresh.setEnableLoadMore(true);

        srfSearchRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                currPage=0;
                mPresenter.getSearchDetial("下拉刷新");

            }
        });

        srfSearchRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //无数据了
                if (currPage>=mPageCount){
                    srfSearchRefresh.finishLoadMoreWithNoMoreData();
                    return;
                }
                mPresenter.getSearchDetial("上拉加载");

            }
        });
    }

    private void hanldeEtOnKey() {
        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edtSearch.getApplicationWindowToken(), 0);
                    }
                    //处理事件
                    LogUtils.d("点击了回车键");
                    mPresenter.getSearchDetial("下拉刷新");

                    return  true;
                }

                return false;
            }
        });
    }

    @Override
    public Dialog getLoadDialog() {
        return dialog;
    }

    @Override
    public void cancelLoadDialog() {
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }

    }

    @Override
    public void getMainListSuccess(MainListBean.DataBean dataBean,String type) {
        currPage=dataBean.getCurPage();
        mPageCount=dataBean.getPageCount();

        if (type.equals("下拉刷新")){

            searchList.clear();
            searchList.addAll(dataBean.getDatas());

            if (homeAdapter==null){

                rvSearch.setLayoutManager(new LinearLayoutManager(this));
                homeAdapter = new HomeAdapter(this,R.layout.item_home_list,searchList);

                homeAdapter.setHasStableIds(true);
                homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                homeAdapter.isFirstOnly(false);
                rvSearch.setAdapter(homeAdapter);

                homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HomeFragment.startArticleDetail(SearchDetailActivity.this,searchList.get(position).getTitle(),searchList.get(position).getLink()+"");
                    }
                });
            }else {
                homeAdapter.refresh(dataBean);

            }
            srfSearchRefresh.finishRefresh();
        }


        else if (type.equals("上拉加载")){
            if (homeAdapter == null) {
                srfSearchRefresh.finishLoadMoreWithNoMoreData();
                return;
            }
            final List<MainListBean.DataBean.DatasBean> loadList = new ArrayList<>();
            loadList.clear();
            loadList.addAll(dataBean.getDatas());
            homeAdapter.Load(loadList);
        }

        if (searchList==null|searchList.size()==0){
            llEmpty.setVisibility(View.VISIBLE);
            srfSearchRefresh.setVisibility(View.GONE);
        }else {
            llEmpty.setVisibility(View.GONE);
            srfSearchRefresh.setVisibility(View.VISIBLE);
        }

        srfSearchRefresh.finishLoadMore(/*,false*/);//不传时间则立即停止刷新    传入false表示加载失败

    }

    @Override
    public void getMainListFail() {
        srfSearchRefresh.finishLoadMore(/*,false*/);//不传时间则立即停止刷新    传入false表示加载失败
        srfSearchRefresh.finishRefresh();
    }

    @Override
    public int getPage() {
        return currPage;
    }

    @Override
    public String getK() {
        return edtSearch.getText().toString().trim();
    }
}
