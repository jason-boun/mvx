package com.jason.mvc;

import android.os.Handler;
import android.util.Log;

import com.jason.utils.CallBack;

/**
 * Created by JiaBo on 2017/11/8.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String name, final String pwd, final CallBack callBack) {
        Log.d("登录中", "登录中");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("dji".equals(name) && "123".equals(pwd)) {
                    callBack.success();

                } else {
                    callBack.fail(401, "用户名或密码不正确");

                }

            }
        }, 2000);
    }
}
