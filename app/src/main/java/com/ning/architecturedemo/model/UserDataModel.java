package com.ning.architecturedemo.model;

import android.os.Handler;

import com.ning.architecturedemo.base.BaseCallback;
import com.ning.architecturedemo.base.BaseModel;

/**
 * Created by chenning on 2020/3/30
 */
public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final BaseCallback<String> callback) {
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]){

                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;

                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;

                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }

        },2000);
    }
}
