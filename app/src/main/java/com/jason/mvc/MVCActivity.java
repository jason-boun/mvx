package com.jason.mvc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jason.utils.CallBack;
import com.jason.mvx.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JiaBo on 2017/11/8.
 */

public class MVCActivity extends AppCompatActivity {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pwd)
    EditText editPwd;

    private ProgressDialog progressDialog;
    private LoginModel loginModel;
    private String name = "";
    private String pwd = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC-Demo");
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        loginModel = new LoginModelImpl();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中...");
        progressDialog.setCancelable(false);
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                name = editName.getText().toString();
                pwd = editPwd.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();
                    loginModel.login(name, pwd, new CallBack() {
                        @Override
                        public void success() {
                            progressDialog.dismiss();
                            Toast.makeText(MVCActivity.this, "success", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void fail(int code, String msg) {
                            progressDialog.dismiss();
                            Toast.makeText(MVCActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
            case R.id.btn_clear:
                editName.setText("");
                editPwd.setText("");
                break;
        }
    }
}
