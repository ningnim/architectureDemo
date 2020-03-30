package com.ning.architecturedemo;

import com.ning.architecturedemo.base.BaseView;
import com.ning.architecturedemo.bean.Translation;

/**
 * Created by chenning on 2020/3/26
 */
public interface MvpView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

    void showData(Object data);

}
