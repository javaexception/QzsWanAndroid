package com.qzs.wanandroid.common;

import android.support.annotation.IntDef;


@IntDef({ItemType.BIG_SORT, ItemType.SMALL_SORT})
public @interface ItemType {
    int BIG_SORT = 0;
    int SMALL_SORT = 1;
}
