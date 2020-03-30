package com.ning.architecturedemo;

import com.ning.architecturedemo.base.BasePresenter;
import com.ning.architecturedemo.manager.DataModel;
import com.ning.architecturedemo.manager.Token;
import com.ning.architecturedemo.model.UserDataModel;

/**
 * Created by chenning on 2020/3/26
 */
public class MvpPresenter extends BasePresenter<MvpView> {


    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {

        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }

        //显示正在加载进度条
        getView().showLoading();

        // 调用Model请求数据
        DataModel.request(UserDataModel.class)
                .params(params)
                .execute(new MvpCallback() {
                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        if (isViewAttached()) {
                            getView().showData(data);
                        }
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        if (isViewAttached()) {
                            getView().showToast(msg);
                        }
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        if (isViewAttached()) {
                            getView().showErr();
                        }
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        if (isViewAttached()) {
                            getView().hideLoading();
                        }
                    }
                });
    }

    public void getNetData(){
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }
        //显示正在加载进度条
        getView().showLoading();
        DataModel.request(UserDataModel.class)
                .requestGetAPI("http://sportsnba.qq.com/", new MvpCallback() {
                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        if (isViewAttached()) {
                            getView().showData(data);
                        }
                    }

                    @Override
                    public void onFailure(String msg) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached()) {
                            getView().hideLoading();
                        }
                    }
                });
    }
}
