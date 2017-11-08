package com.jason.mvp;

import android.app.ProgressDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jason.mvx.R;
import com.jason.mvp.base.BaseActivity;
import com.jason.mvp.core.LoginContract;
import com.jason.mvp.core.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JiaBo on 2017/11/8.
 */

public class MVPActivity extends BaseActivity<LoginPresenter, com.jason.mvp.core.LoginModel> implements LoginContract.View {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;
    @BindView(R.id.btn_clear)
    AppCompatButton btnClear;

    private ProgressDialog progressDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_mvc;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setViewAndModel(this, mModel);
    }

    @Override
    protected void initView() {
        setTitle("MVP-Demo");
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中...");
        progressDialog.setCancelable(false);
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
//                mPresenter.rxLogin(editName.getText().toString(), editPwd.getText().toString());
                mPresenter.login(editName.getText().toString(), editPwd.getText().toString());
                break;
            case R.id.btn_clear:
                mPresenter.clear();
                break;
        }
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void success() {
        Toast.makeText(this, "mvp-登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this, "mvp-登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        editName.setText("");
        editPwd.setText("");
    }
}
