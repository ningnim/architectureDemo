package com.ning.architecturedemo.manager;

import com.ning.architecturedemo.base.BaseModel;

/**
 * Created by chenning on 2020/3/30
 */
public class DataModel {
    public static BaseModel request(Class clazz) {
        // 声明一个空的BaseModel
        BaseModel model = null;
        // 判断class对象是不是BaseModel的实例
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static <T extends BaseModel> T request1(Class<T> cls) {
        // 声明一个空的BaseModel
        T model = null;
        try {
            //利用反射机制获得对应Model对象的引用
            model = (T) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
