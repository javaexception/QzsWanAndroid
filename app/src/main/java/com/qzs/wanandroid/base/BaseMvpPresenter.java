package com.qzs.wanandroid.base;

import java.lang.ref.WeakReference;


public class BaseMvpPresenter<V extends IBaseMvpView> {

    /**
     * v层泛型引用
     */
    protected V mView;

    private WeakReference<V> weakReferenceView;
    //防止空指针
    protected V getView(){
        if(mView == null) {
            throw new IllegalStateException("view not attached");
        }
        else{
            return mView;
        }
    }

    public void attachMvpView(V view) {
        if (view!=null){
            weakReferenceView = new WeakReference<>(view);
            this.mView = weakReferenceView.get();
        }

    }


    public void detachMvpView() {
        weakReferenceView.clear();
        weakReferenceView = null;
        mView = null;
    }


}
