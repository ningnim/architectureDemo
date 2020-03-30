package com.ning.architecturedemo.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenning on 2020/3/30
 */
public class RetrofitUtil {

    public Retrofit retrofitClient;
    public Retrofit retrofitClient1;
    public Retrofit retrofitClient2;

    public static final String HTTP_SPORTSNBA_QQ_COM = "http://sportsnba.qq.com/";

    private static RetrofitUtil retrofitUtil = new RetrofitUtil();

    public static RetrofitUtil getRetrofitUtil() {
        return retrofitUtil;
    }


    public RetrofitUtil() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);

        retrofitClient = new Retrofit.Builder()
                .baseUrl(HTTP_SPORTSNBA_QQ_COM)
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(client.build())
                .build();

        retrofitClient1 = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();
        retrofitClient2 = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();
    }
}
