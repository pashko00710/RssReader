package com.snijsure.rssreader.data.network;

import com.snijsure.rssreader.data.network.model.RssFeed;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface RestService {
    @GET("all")
    Observable<Response<RssFeed>> getAllTimeRssItems();
    @GET("weekly")
    Observable<Response<RssFeed>> getWeeklyRssItems();
    @GET("monthly")
    Observable<Response<RssFeed>> getMonthlyRssItems();
}
