package com.ning.architecturedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ning.architecturedemo.base.BaseActivity;
import com.ning.architecturedemo.base.BasePresenter;

public class MainActivity extends BaseActivity implements MvpView  {

    TextView text;

    MvpPresenter mvpPresenter = null;

    @Override
    public BasePresenter getPresenter() {
        return mvpPresenter;
    }

    @Override
    public void initPresenter() {
        mvpPresenter = new MvpPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showErr() {
        super.showErr();
        text.setText("showErr");
    }


    // button 点击事件调用方法
    public void getData(View view){
        mvpPresenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view){
        mvpPresenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view){
        mvpPresenter.getData("error");
    }
}