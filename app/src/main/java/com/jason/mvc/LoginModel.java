package com.jason.mvc;

import com.jason.utils.CallBack;

/**
 * Created by JiaBo on 2017/11/8.
 */

public interface LoginModel {

    void login(String name, String pwd, CallBack callBack);
}
