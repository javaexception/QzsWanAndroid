package com.qzs.wanandroid.ui.information.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpFragment;
import com.qzs.wanandroid.base.SimpleRecyclerAdapter;
import com.qzs.wanandroid.common.ItemType;
import com.qzs.wanandroid.mvp.presenter.NavigatePresenter;
import com.qzs.wanandroid.mvp.view.INavigateView;
import com.qzs.wanandroid.ui.information.activity.ArticleDetailsActivity;
import com.qzs.wanandroid.ui.information.adapter.LeftAdapter;
import com.qzs.wanandroid.ui.information.adapter.RightAdapter;
import com.qzs.wanandroid.ui.information.bean.NavigateBean;
import com.qzs.wanandroid.utils.LogUtils;
import com.qzs.wanandroid.utils.MyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 导航=fragment
 */
public class NavigateFragment extends BaseMvpFragment<INavigateView, NavigatePresenter> implements INavigateView {

    private List<NavigateBean.DataBean>  navigateList=new ArrayList<>();

    private  List<NavigateBean.DataBean.ArticlesBean>  concreteList=new ArrayList<>();

    private final Map<Integer, Integer> indexMap = new HashMap<>();

    private RecyclerView leftRecyclerView;
    private RecyclerView rightRecyclerView;


    private LeftAdapter leftAdapter;

    private RightAdapter rightAdapter;

    private Gson gson;

    private LinearLayout llError;
    private AppCompatTextView tvLoad;




    @Override
    protected NavigatePresenter createPresenter() {

        return new NavigatePresenter();
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.tv_load){

            mPresenter.getNavigateList();
        }

    }

    @Override
    public Dialog getLoadDialog() {
        return dialog;
    }

    @Override
    public void cancelLoadDialog() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_navigate;
    }

    @Override
    public void initView() {
        llError =rootView. findViewById(R.id.ll_error);
        tvLoad = rootView.findViewById(R.id.tv_load);
        leftRecyclerView =rootView. findViewById(R.id.rv_sort_left);
        rightRecyclerView = rootView.findViewById(R.id.rv_sort_right);
        tvLoad.setOnClickListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getNavigateList();

    }

    /**
     * 提供Fragment实例
     *
     * @return
     */
    public static NavigateFragment newInstance() {

        NavigateFragment fragment = new NavigateFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void navigateListSuccess(List<NavigateBean.DataBean> dataBean) {
        llError.setVisibility(View.GONE);
        gson=new Gson();
        navigateList.clear();
        navigateList.addAll(dataBean);
        concreteList.clear();
        for (int i=0;i<dataBean.size();i++){
            NavigateBean.DataBean.ArticlesBean articlesBean1=new NavigateBean.DataBean.ArticlesBean(true,dataBean.get(i).getName());
            articlesBean1.position=i;
            articlesBean1.viewType = ItemType.BIG_SORT;
            concreteList.add(articlesBean1);
            for (int j=0;j<dataBean.get(i).getArticles().size();j++){
                NavigateBean.DataBean.ArticlesBean articlesBean2=new NavigateBean.DataBean.ArticlesBean(false,dataBean.get(i).getName());
                articlesBean2.position=-1;
                articlesBean2.viewType=ItemType.SMALL_SORT;
                articlesBean2.setTitle(dataBean.get(i).getArticles().get(j).getTitle());
                articlesBean2.setLink(dataBean.get(i).getArticles().get(j).getLink());
                concreteList.add(articlesBean2);
            }

        }
        LogUtils.d("concreteList--- "+gson.toJson(concreteList));

        // 点击左侧需要知道对应右侧的位置，用map先保存起来
        for (int i = 0; i < concreteList.size(); i++) {
            if (concreteList.get(i).position != -1) {
                indexMap.put(concreteList.get(i).position, i);
            }
        }

        LogUtils.d("indexMap--- "+gson.toJson(indexMap));

        // 左列表
        leftRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((SimpleItemAnimator) leftRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        leftAdapter = new LeftAdapter();
        leftAdapter.setListData(navigateList);
        leftRecyclerView.setAdapter(leftAdapter);
        // 左侧列表的点击事件
        leftAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<NavigateBean.DataBean>() {
            @Override
            public void onItemClick(NavigateBean.DataBean item, int index) {
                // 左侧选中并滑到中间位置
                leftAdapter.setSelectedPosition(index);
                MyUtils.moveToMiddle(leftRecyclerView, index);
                // 右侧滑到对应位置
                ((GridLayoutManager)rightRecyclerView.getLayoutManager())
                        .scrollToPositionWithOffset(indexMap.get(index),0);
            }
        });
        // 右列表
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                if (concreteList.get(position).viewType == ItemType.BIG_SORT) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        rightRecyclerView.setLayoutManager(gridLayoutManager);
        rightAdapter = new RightAdapter();
        rightAdapter.setListData(concreteList);
        rightRecyclerView.setAdapter(rightAdapter);
        rightAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<NavigateBean.DataBean.ArticlesBean>() {
            @Override
            public void onItemClick(NavigateBean.DataBean.ArticlesBean item, int index) {
                NavigateFragment.startArticleDetail(getActivity(),item.getLink());
            }
        });
        //右侧列表的滚动事件
        rightRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //获取右侧列表的第一个可见Item的position
                int topPosition = ((GridLayoutManager) rightRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                // 如果此项对应的是左边的大类的index
                if (concreteList.get(topPosition).position != -1) {
                    MyUtils.moveToMiddle(leftRecyclerView, concreteList.get(topPosition).position);
                    leftAdapter.setSelectedPosition(concreteList.get(topPosition).position);
                }

            }
        });

    }


    @Override
    public void navigateListFail() {
        llError.setVisibility(View.VISIBLE);
    }

    public   static  void  startArticleDetail(Context context,String url){
        Intent intent=new Intent(context, ArticleDetailsActivity.class);
        intent.putExtra("url",url);
        context.startActivity(intent);

    }


}
