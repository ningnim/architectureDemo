package com.ning.architecturedemo.netservice;


import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIService {

    @GET("news/item")
    Call<ResponseBody> getNBANews(@Query("column") String column,
                                  @Query("articleIds") String articleIds);
    @GET("news/item")
    Call<ResponseBody> getNBANews(@QueryMap HashMap<String, Object> map);

}