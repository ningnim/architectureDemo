package com.ning.architecturedemo.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.ning.architecturedemo.R;

/**
 * Created by chenning on 2020/3/26
 */
public abstract class BaseActivity extends Activity implements BaseView {

    private ProgressDialog mProgressDialog;

    /**
     * 获取Presenter实例，子类实现
     */
    public abstract BasePresenter getPresenter();

    /**
     * 初始化Presenter的实例，子类实现
     */
    public abstract void initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("正在加载数据");
        initPresenter();
        if (getPresenter() != null){
            getPresenter().attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null){
            getPresenter().detachView();
        }
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
