package com.jason.mvp.base;

/**
 * Created by JiaBo on 2017/11/9.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jason.utils.Util;

/**
 * 基类模板
 *
 * @param <P>
 * @param <M>
 */
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    public Context activity;
    public P mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        activity = this;
        mPresenter = Util.getT(this, 0);
        mModel = Util.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        initView();
        initPresenter();
    }

    protected abstract int initLayout();

    protected abstract void initPresenter();

    protected abstract void initView();


}
