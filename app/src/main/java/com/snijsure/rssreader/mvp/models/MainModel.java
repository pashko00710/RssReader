package com.snijsure.rssreader.mvp.models;

import android.content.Context;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.snijsure.rssreader.data.managers.DataManager;
import com.snijsure.rssreader.data.storage.realm.RssItemRealm;

import rx.Observable;

public class MainModel {
    private Context mContext;
    private DataManager mDataManager;

    public MainModel() {
        mDataManager = DataManager.getInstance();
        mContext = mDataManager.getContext();
    }
    @RxLogObservable
    public Observable<RssItemRealm> getRssItemsObs(String channel) {
        Observable<RssItemRealm> disk = fromDisk(channel);
        Observable<RssItemRealm> network = fromNetwork(channel).cache();
        return Observable.mergeDelayError(disk, network)
                .distinct(RssItemRealm::getId);
    }

    @RxLogObservable
    public Observable<RssItemRealm> fromNetwork(String channel) {
        return mDataManager.getRssItemsObsFromNetwork(channel);
    }

    @RxLogObservable
    public Observable<RssItemRealm> fromDisk(String channel) {
        return mDataManager.getRssItems(channel);
    }
}
