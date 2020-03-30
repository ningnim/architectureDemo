package com.ning.architecturedemo.model;

import android.util.Log;

import com.ning.architecturedemo.base.BaseCallback;
import com.ning.architecturedemo.base.BaseModel;
import com.ning.architecturedemo.bean.Translation;
import com.ning.architecturedemo.bean.Translation1;
import com.ning.architecturedemo.net.RetrofitUtil;
import com.ning.architecturedemo.netservice.WordService;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chenning on 2020/3/30
 */
public class WordDataModel extends BaseModel<Translation> {

    @Override
    public void execute(BaseCallback<Translation> callback) {

    }

    @Override
    public void requestGetAPI(Map<String, Object> params, final BaseCallback<Translation> callback) {
        WordService request = RetrofitUtil.getRetrofitUtil().retrofitClient1.create(WordService.class);

        //对 发送请求 进行封装
        //?a=fy&f=auto&t=auto&w=hello%20world

        Call<Translation> call = request.getCall(params);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                Log.e("chenning", "结果："+response.body().toString());
                callback.onSuccess(response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
                callback.onFailure("连接失败");
            }
        });
    }

    public void requestPostAPI(final BaseCallback<Translation1> callback) {
        // 步骤5:创建 网络请求接口 的实例
        WordService request = RetrofitUtil.getRetrofitUtil().retrofitClient2.create(WordService.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation1> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation1>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                Log.e("chenning", "response:"+response.toString());
                callback.onSuccess(response.body());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation1> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }
}
