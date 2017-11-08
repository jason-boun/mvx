package com.jason.mvp.core;

import com.jason.utils.CallBack;
import com.jason.mvp.base.BaseModel;
import com.jason.mvp.base.BasePresenter;
import com.jason.mvp.base.BaseView;

/**
 * Created by JiaBo on 2017/11/9.
 */

public interface LoginContract {

    interface Model extends BaseModel {
        void login(String name, String pwd, CallBack callBack);

        rx.Observable<String> rxLogin(String name, String pwd);
    }

    interface View extends BaseView {
        void success();

        void failed();

        void clear();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void login(String name, String pwd);

        abstract void rxLogin(String name, String pwd);

        abstract void clear();
    }
}
