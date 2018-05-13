package com.yskj.bilibili.module;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.RxLifecycle;
import com.yskj.bilibili.R;
import com.yskj.bilibili.base.RxBaseActivity;
import com.yskj.bilibili.entity.recommend.RecommendInfo;
import com.yskj.bilibili.module.entry.HomePageFragment;
import com.yskj.bilibili.network.RetrofitHelper;
import com.yskj.bilibili.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends RxBaseActivity {

    private List<RecommendInfo.ResultBean> mResultBeanList;
    private HomePageFragment mHomePageFragment;
    private Fragment[] mFragments;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

        //初始化侧滑菜单
        initNavigationView();
        //初始化Fragment
        initFragments();

    }

    private void initFragments() {
        mHomePageFragment = HomePageFragment.newInstance();
        mFragments = new Fragment[]{
                mHomePageFragment
        };
        // 添加显示第一个fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mHomePageFragment)
                .show(mHomePageFragment).commit();
    }

    private void initNavigationView() {
        NavigationView navigationMenuView = (NavigationView) findViewById(R.id.nav);
        UIUtils.disableNvigationViewScrollbars(navigationMenuView);
    }

    @Override
    public void initToolBar() {

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
