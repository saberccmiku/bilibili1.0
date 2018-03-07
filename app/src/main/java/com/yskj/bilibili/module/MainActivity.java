package com.yskj.bilibili.module;

import android.os.Bundle;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.RxLifecycle;
import com.yskj.bilibili.R;
import com.yskj.bilibili.entity.recommend.RecommendInfo;
import com.yskj.bilibili.network.RetrofitHelper;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends RxBaseActivity {

    private List<RecommendInfo.ResultBean> mResultBeanList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();

    }

    @Override
    public void loadData() {
        newLoadData();
    }

    private void newLoadData() {

        mResultBeanList = new ArrayList<>();
        RetrofitHelper.getAppAPI()//基础URL
                .getRecommendedInfo()//接口后缀URL
                .compose(RxLifecycle.bindUntilEvent(lifecycle(), ActivityEvent.DESTROY))//设计是否备份数据
                .map(RecommendInfo::getResult)//得到JSON子数组
                .subscribeOn(Schedulers.io())//设计线程读写方式
                .observeOn(AndroidSchedulers.mainThread())//指定线程运行的位置
                .subscribe(new Observer<List<RecommendInfo.ResultBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<RecommendInfo.ResultBean> resultBeen) {
                        System.out.println("resultBeen:"+resultBeen);
                    }
                });
    }

    //处理业务

}
