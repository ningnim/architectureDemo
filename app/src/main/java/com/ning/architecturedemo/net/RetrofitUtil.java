package com.ning.architecturedemo.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by chenning on 2020/3/30
 */
public class RetrofitUtil {

    Retrofit retrofitClient;

    public static final String HTTP_SPORTSNBA_QQ_COM = "http://sportsnba.qq.com/";

    private static RetrofitUtil retrofitUtil = new RetrofitUtil();

    public static RetrofitUtil getRetrofitUtil() {
        return retrofitUtil;
    }

    public Retrofit getRetrofitClient() {
        return retrofitClient;
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
    }
}
