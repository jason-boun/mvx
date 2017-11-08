package com.jason.mvp.core;

import android.text.TextUtils;
import android.widget.Toast;

import com.jason.utils.CallBack;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JiaBo on 2017/11/9.
 */

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String name, String pwd) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(mContext, "mvp-请输入用户名和密码", Toast.LENGTH_SHORT).show();
        } else {
            mView.showLoading();
            mModel.login(name, pwd, new CallBack() {
                @Override
                public void success() {
                    mView.success();
                    mView.hideLoading();
                }

                @Override
                public void fail(int code, String msg) {
                    mView.failed();
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    public void rxLogin(String name, String pwd) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(mContext, "mvp-请输入用name和pwd", Toast.LENGTH_SHORT).show();
        } else {
            mView.showLoading();
            mModel.rxLogin(name, pwd)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {
                            mView.hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.hideLoading();
                        }

                        @Override
                        public void onNext(String msg) {
                            mView.hideLoading();
                            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    @Override
    public void clear() {
        mView.clear();
    }
}
