package com.jason.mvp.base;

import android.content.Context;

/**
 * Created by JiaBo on 2017/11/9.
 */

public abstract class BasePresenter<V, M> {

    public Context mContext;
    public V mView;
    public M mModel;

    public void setViewAndModel(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }
}
