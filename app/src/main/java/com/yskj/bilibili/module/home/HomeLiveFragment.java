package com.yskj.bilibili.module.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yskj.bilibili.R;
import com.yskj.bilibili.base.RxLazyFragment;
import com.yskj.bilibili.widget.CustomEmptyView;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页直播界面
 */
public class HomeLiveFragment extends RxLazyFragment {

    private RecyclerView mRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private CustomEmptyView mCustomEmptyView;


    public static HomeLiveFragment newIntance() {
        return new HomeLiveFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_live;
    }

    @Override
    public void finishCreateView(Bundle state) {
        mRecyclerView = findViewById(R.id.recycle);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mCustomEmptyView = findViewById(R.id.empty_layout);
        mIsPrepared = true;
        lazyLoad();
    }


    @Override
    protected void lazyLoad() {
        if (!mIsPrepared || !mIsVisible) {
            return;
        }
        initRefreshLayout();
        initRecyclerView();
        mIsPrepared = false;
    }

    @Override
    protected void initRecyclerView() {
    }


    @Override
    protected void initRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this::loadData);
        mSwipeRefreshLayout.post(() -> {
            mSwipeRefreshLayout.setRefreshing(true);
            loadData();
        });
    }

    @Override
    protected void loadData() {

    }


    private void initEmptyView() {

    }


    public void hideEmptyView() {
        mCustomEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void finishTask() {

    }
}
