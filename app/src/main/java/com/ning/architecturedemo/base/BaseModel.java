package com.ning.architecturedemo.base;

import java.util.Map;

/**
 * Created by chenning on 2020/3/30
 */
public abstract class BaseModel<T>  {

    //数据请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     * @param args 参数数组
     */
    public  BaseModel params(String... args){
        mParams = args;
        return this;
    }

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(BaseCallback<T> callback);

    // 执行Get网络请求，此类看需求由自己选择写与不写
    public void requestGetAPI(String url,BaseCallback<T> callback){
        //这里写具体的网络请求
    }
    // 执行Get网络请求，此类看需求由自己选择写与不写
    public void requestGetAPI(Map<String, Object> params,BaseCallback<T> callback){
        //这里写具体的网络请求
    }

    // 执行Post网络请求，此类看需求由自己选择写与不写
    public void requestPostAPI(String url, Map params, BaseCallback<T> callback){
        //这里写具体的网络请求
    }

}
