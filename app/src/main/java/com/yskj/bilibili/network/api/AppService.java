package com.yskj.bilibili.network.api;

import com.yskj.bilibili.entity.recommend.RecommendBannerInfo;
import com.yskj.bilibili.entity.recommend.RecommendInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 商品相关的接口
 * Created by saber on 2018/1/4
 */

public interface AppService {

    /**
     * 首页推荐数据
     */
    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();

    /**
     * 首页推荐banner
     */
    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    Observable<RecommendBannerInfo> getRecommendedBannerInfo();

}
