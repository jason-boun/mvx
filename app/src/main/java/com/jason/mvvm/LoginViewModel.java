package com.jason.mvvm;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by JiaBo on 2017/11/9.
 */

public class LoginViewModel {
    private Context mContext;
    private ProgressDialog progressDialog;
    private LoginModel loginModel;

    public LoginViewModel(Context context, LoginModel userLoginModel) {
        this.mContext = context;
        this.loginModel = userLoginModel;
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("登陆中,请稍后...");
        progressDialog.setCancelable(false);
    }


    /**
     * 登陆方法
     */
    public void login() {
        if (TextUtils.isEmpty(loginModel.getUserName()) || TextUtils.isEmpty(loginModel.getPassWord())) {
            Toast.makeText(mContext, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if ("dji".equals(loginModel.getUserName().toString().trim()) && "123".equals(loginModel.getPassWord().toString().trim())) {
                        Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        loginModel.setUserName("DJI");
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                }
            }, 2000);
        }

    }

    public void clear() {
        loginModel.setUserName("");
        loginModel.setPassWord("");
        loginModel.setUserPhoto("http://www.zhuobufan.com/UserFiles/Attachment/16/12_05/e8b31de4-4f51-43b7-833c-e9a37cd174e9.jpg");

    }

    //用户名变化监听
    public TextWatcher userNameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("userName", editable.toString());
            loginModel.setUserName(editable.toString());
        }
    };
    //密码变化监听
    public TextWatcher passWordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("passWord", editable.toString());
            loginModel.setPassWord(editable.toString());
        }
    };
}
