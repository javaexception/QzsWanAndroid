package com.qzs.wanandroid.ui.information.activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.gyf.immersionbar.ImmersionBar;
import com.qzs.wanandroid.R;
import com.qzs.wanandroid.base.BaseMvpActivity;
import com.qzs.wanandroid.mvp.presenter.ArticleDetailsPresenter;
import com.qzs.wanandroid.mvp.view.IArticleDetailView;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import static android.view.View.VISIBLE;
import static com.tencent.smtt.sdk.WebSettings.LOAD_NO_CACHE;

/**
 * @author qinzishuai
 * 描述：  文章详情
 * 创建日期：2019/7/19
 *
 */
public class ArticleDetailsActivity extends BaseMvpActivity<IArticleDetailView, ArticleDetailsPresenter> {

    private WebView webview;

    private Toolbar toolbar;


    private  ProgressBar mProgressBar;


    private String mUrl = "";   //链接地址

    private String mTitle="";

    private ImageView ivToolbarLeft;

    private AppCompatTextView tvTitle;

    private ImageView ivShare;



    @Override
    protected ArticleDetailsPresenter createPresenter() {
        return new ArticleDetailsPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.iv_toolbar_left){
            finish();
        }

        if (v.getId()==R.id.iv_share){
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setType("text/plain");
            textIntent.putExtra(Intent.EXTRA_TEXT, mUrl);
            startActivity(Intent.createChooser(textIntent, mTitle));

        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_article_detail;
    }

    @Override
    public void initView() {
        ivShare = findViewById(R.id.iv_share);
        webview = findViewById(R.id.webview);
        ivToolbarLeft = findViewById(R.id.iv_toolbar_left);
        tvTitle = findViewById(R.id.tv_title);
        toolbar = findViewById(R.id.toolbar);

        ivShare.setOnClickListener(this);
        ivToolbarLeft.setOnClickListener(this);

        mProgressBar = new ProgressBar(this, null,
                android.R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 8);
        mProgressBar.setLayoutParams(layoutParams);

        webview.addView(mProgressBar);
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this).titleBar(R.id.toolbar).init();

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initIntent();
        initWebView();



    }

    private void initIntent() {
        Intent intent=getIntent();
        if (intent!=null){
            mTitle=intent.getStringExtra("title");
            mUrl=intent.getStringExtra("url");
        }
    }


    /**
     * 初始化webview并加载URL
     */
    private void initWebView() {

        webview.getSettings().setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webview.getSettings().setBuiltInZoomControls(false); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webview.getSettings().setDisplayZoomControls(true); //隐藏原生的缩放控件
        webview.getSettings().setBlockNetworkImage(false);//解决图片不显示
        webview.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        webview.getSettings().setDefaultTextEncodingName("utf-8");//设置编码格式
        webview.getSettings().setCacheMode(LOAD_NO_CACHE);
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // 获取网页加载进度
        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    tvTitle.setText(view.getTitle());
                    mProgressBar.setVisibility(View.GONE);
                } else {

                    if (mProgressBar.getVisibility() == View.GONE)
                        mProgressBar.setVisibility(VISIBLE);
                    mProgressBar.setProgress(newProgress);
                    tvTitle.setText("正在加载....");
                }
            }
        });

        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl(mUrl);

    }




    @Override
    public Dialog getLoadDialog() {
        return null;
    }

    @Override
    public void cancelLoadDialog() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.webview != null) {
            webview.clearCache(true);
            webview.clearHistory();
            //((ViewGroup)webview.getParent()).removeView(webview);
            webview.destroy();
        }
    }
}
