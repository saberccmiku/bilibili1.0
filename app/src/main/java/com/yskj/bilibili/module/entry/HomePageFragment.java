package com.yskj.bilibili.module.entry;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.yskj.bilibili.R;
import com.yskj.bilibili.base.RxLazyFragment;
import com.yskj.bilibili.module.MainActivity;
import com.yskj.bilibili.widget.CircleImageView;

public class HomePageFragment  extends RxLazyFragment{

    private Toolbar mToolbar;
    private CircleImageView mCircleImageView;
    private MaterialSearchView mSearchView;

    public static HomePageFragment newInstance(){
        return new HomePageFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar();
        initSearchView();
        initViewPager();
    }

    private void initViewPager() {

    }

    private void initSearchView() {
        mSearchView =findViewById(R.id.search_view);
        //初始化SearchBar
        mSearchView.setVoiceSearch(false);
        mSearchView.setCursorDrawable(R.drawable.custom_cursor);
        mSearchView.setEllipsize(true);
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               // TotalStationSearchActivity.launch(getActivity(), query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initToolBar() {
        mToolbar = findViewById(R.id.toolbar);
        mCircleImageView = findViewById(R.id.toolbar_user_avatar);

        ((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setTitle("");
        mCircleImageView.setImageResource(R.drawable.ic_hotbitmapgg_avatar);
    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void onVisible() {

    }
}
