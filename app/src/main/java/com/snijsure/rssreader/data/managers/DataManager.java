package com.snijsure.rssreader.data.managers;

import android.content.Context;

import com.snijsure.rssreader.App;
import com.snijsure.rssreader.data.network.RestCallTransformer;
import com.snijsure.rssreader.data.network.RestService;
import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.snijsure.rssreader.data.network.model.RssFeed;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DataManager {
    private Context mContext;
    private static DataManager ourInstance;

    RestService mRestService;
    RealmManager mRealmManager;
    Retrofit mRetrofit;

    public DataManager() {
        this.mContext = App.getContext();
        OkHttpClient okHttpClient = App.createClient();
        mRetrofit = App.createRetrofit(okHttpClient);
        mRestService = mRetrofit.create(RestService.class);
        mRealmManager = new RealmManager();
    }

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance ;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }


    public Observable<RssItemRealm> getRssItemsObsFromNetwork(String channel) {
        Observable<Response<RssFeed>> items = null;
        if(channel.contains("all")) {
            items = mRestService.getAllTimeRssItems();
        } else if(channel.contains("weekly")) {
            items = mRestService.getWeeklyRssItems();
        } else if(channel.contains("monthly")) {
            items = mRestService.getMonthlyRssItems();
        }

        return items.compose(new RestCallTransformer<>())
                .flatMap(Observable::just) // преобразуем список List в последовательность
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .flatMap(rssFeed -> Observable.from(new RssFeed[]{rssFeed}))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(quotesResponse -> mRealmManager.saveQuotesResponseToRealm(quotesResponse, channel))
                .flatMap(productRes -> Observable.empty());
    }

    public Context getContext(){return mContext;}

    public RealmManager getRealmManager() {
        return mRealmManager;
    }

    public Observable<RssItemRealm> getRssItems(String channel) {
        return getRealmManager().getRssItemsFromRealm(channel);
    }
}
