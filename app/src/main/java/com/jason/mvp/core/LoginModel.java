package com.jason.mvp.core;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import com.jason.utils.CallBack;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by JiaBo on 2017/11/9.
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public void login(final String name, final String pwd, final CallBack callBack) {
        Log.d("登录中", "登录中");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("dji".equals(name) && "123".equals(pwd)) {
                    callBack.success();

                } else {
                    callBack.fail(401, "mvp-用户名或密码不正确");

                }

            }
        }, 2000);
    }

    @Override
    public Observable<String> rxLogin(final String name, final String pwd) {
        return rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                SystemClock.sleep(2000);
                if ("dji".equals(name) && "123".equals(pwd)) {
                    subscriber.onNext("mvp-rx-success");
                    subscriber.onCompleted();
                } else {
                    subscriber.onNext("mvp-rx-fail");
                    subscriber.onCompleted();
                }

            }
        });
    }
}
