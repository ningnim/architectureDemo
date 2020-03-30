# 架构演进之路
## BaseCallback
1. 对CallBack进行了基本方法的抽取，定义了网络请求接口回来后常用的回调;
2. 使用了泛型，因为请求回来成功的Bean对象是五花八门的。
## BaseView
1. 对Activity需要实现的View接口进行了抽取，定义了常用的view的操作，比如弹toast，
loading框的展示和消失；
2. 提供了一个getContext()方法。
## BasePresenter
1. 将原先MvpPresenter中的通用的attachView()、detachView()和isViewAttached()抽取到基类中；
2. 提供了一个getView()来让子Presenter获取到view层实例；
3. 使用了泛型，并且让其继承自BaseView，这样会约束View层的方法，
避免传给p层的view引用没有定义好的通用方法，形式为BasePresenter<V extends BaseView>
## BaseActivity
1. 实现了BaseView这个接口，将其通用的接口方法都实现掉，比如弹toast，
loading框的展示和消失，getContext()方法；
## BaseFragment
也是属于view，跟activity一样，实现BaseView这个接口即可，并且所有的通用方法都
通过getActivity去实现

## model层的封装
主要包括BaseModel，DataModel，Token这三个类
1. 抽取了每个业务model层的基类BaseModel，主要就是请求参数String[] mParams以及三个方法
execute(BaseCallback<T> callback) 、 get请求requestGetAPI(String url,BaseCallback<T> callback)、和
post请求requestPostAPI(String url, Map params, BaseCallback<T> callback)
2. 每个业务presenter层调用model层业务,都通过DataModel这个管理类去做，方便统一管理，使用的是反射方式
>  model = (BaseModel)Class.forName(token).newInstance();
3. token类就是根据各个业务填入各个具体业务的model名称即可，提供给DataModel去反射用的

## 进阶
1. DataModel的反射不需要依赖于Token类管理类，直接传入Class对象
2. 每个activity都需要手动去链接/断开presenter和view，放在BaseActivity中处理即可

## 注意
1. MainActivity extends BaseActivity implements MvpView
2. 而BaseActivity implements BaseView
即从这个角度看MainActivity有两个地方去实现BaseView中的接口，一个是在自身的activity中， 
另一个在父类BaseActivity中