/*
 * Copyright 2016 yinglan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qzs.wanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;


public class HideUtil {

    /**
     * Initialization method
     *
     * @param activity
     */
    public static void init(Activity activity) {
        new HideUtil(activity, null);
    }

    /**
     * Can pass the outer layout
     *
     * @param activity
     * @param content
     */
    public static void init(Activity activity, ViewGroup content) {
        new HideUtil(activity, content);
    }

    /**
     * Can pass the outer layout
     *
     * @param window
     * @param content
     */
    public static void init(Window window, ViewGroup content) {
        new HideUtil(window, content);
    }

    /**
     * Forced hidden keyboard
     *
     * @param activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (null != view) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * Forced hidden keyboard
     *
     * @param view
     */
    public static void hideSoftKeyboard(Context context, View view) {
        if (null != view) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * @param activity
     */
    private HideUtil(final Activity activity, ViewGroup content) {
        if (content == null) {
            content = (ViewGroup) activity.findViewById(android.R.id.content);
        }
        getScrollView(content, activity);
        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                dispatchTouchEvent(activity, motionEvent);

                return false;
            }
        });
    }

    /**
     * @param window
     */
    private HideUtil(final Window window, ViewGroup content) {
        getScrollView(content, window);
        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dispatchTouchEvent(window, motionEvent);
                return false;
            }
        });
    }

    private void getScrollView(ViewGroup viewGroup, final Activity activity) {
        if (null == viewGroup) {
            return;
        }
        int count = viewGroup.getChildCount();
        boolean isLast = true;
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ScrollView) {
                ScrollView newDtv = (ScrollView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        dispatchTouchEvent(activity, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof AbsListView) {
                AbsListView newDtv = (AbsListView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        dispatchTouchEvent(activity, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof RecyclerView) {
                RecyclerView newDtv = (RecyclerView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        dispatchTouchEvent(activity, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof ViewGroup) {
                isLast = false;
                this.getScrollView((ViewGroup) view, activity);
            }
            if (view.isClickable() && view instanceof TextView && !(view instanceof EditText)) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        dispatchTouchEvent(activity, motionEvent);
                        return false;
                    }
                });
            }
        }
        if (isLast){
            viewGroup.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    dispatchTouchEvent(activity, motionEvent);
                    return false;
                }
            });
        }
    }

    private void getScrollView(ViewGroup viewGroup, final Window window) {
        if (null == viewGroup) {
            return;
        }
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ScrollView) {
                ScrollView newDtv = (ScrollView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        dispatchTouchEvent(window, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof AbsListView) {
                AbsListView newDtv = (AbsListView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        dispatchTouchEvent(window, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof RecyclerView) {
                RecyclerView newDtv = (RecyclerView) view;
                newDtv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        dispatchTouchEvent(window, motionEvent);
                        return false;
                    }
                });
            } else if (view instanceof ViewGroup) {
                this.getScrollView((ViewGroup) view, window);
            }

            if (view.isClickable() && view instanceof TextView && !(view instanceof EditText)) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        dispatchTouchEvent(window, motionEvent);
                        return false;
                    }
                });
            }
        }
    }

    /**
     * @param mActivity
     * @param ev
     * @return
     */
    public boolean dispatchTouchEvent(Activity mActivity, MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = mActivity.getCurrentFocus();
            if (null != v && isShouldHideInput(v, ev)) {
                hideSoftInput(mActivity, v.getWindowToken());
            }
        }
        return false;
    }

    /**
     * @param window
     * @param ev
     * @return
     */
    public boolean dispatchTouchEvent(Window window, MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = window.getCurrentFocus();
            if (null != v) {
                hideSoftInput(window, v.getWindowToken());
            }
        }
        return false;
    }

    /**
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v instanceof EditText) {
            Rect rect = new Rect();
            v.getHitRect(rect);
            if (rect.contains((int) event.getX(), (int) event.getY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param mActivity
     * @param token
     */
    private void hideSoftInput(Activity mActivity, IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * @param window
     * @param token
     */
    private void hideSoftInput(Window window, IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) window.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void registerSoftInputListener(Activity context) {
        final View content = (ViewGroup) context.findViewById(android.R.id.content);
        content.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /**
                     * the result is pixels
                     */
                    @Override
                    public void onGlobalLayout() {
                        Rect r = new Rect();
                        content.getWindowVisibleDisplayFrame(r);
                        int screenHeight = content.getRootView().getHeight();
                        int heightDifference = screenHeight - (r.bottom - r.top);
                        //boolean visible = heightDiff > screenHeight / 3;
                    }
                });
    }
}
