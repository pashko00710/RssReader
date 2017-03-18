package com.snijsure.rssreader.data.managers;

import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.snijsure.rssreader.data.network.model.RssFeed;
import com.snijsure.rssreader.data.network.model.RssFeedItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

public class RealmManager {
    private Realm mRealmInstance;
    private int orderId;

    public Observable<RssItemRealm> getRssItemsFromRealm(String channel) {
        RealmResults<RssItemRealm> manageProduct = getQueryRealmInstance().where(RssItemRealm.class).equalTo("channel", channel).findAll();
        return manageProduct
                .asObservable() //получаем RealmResult как Observable
                .filter(RealmResults::isLoaded) //получаем только загруженные результаты (hotObservable)
                //.first() //hack, if need cold observable
                .flatMap(Observable::from);
    }

    private Realm getQueryRealmInstance() {
        if(mRealmInstance == null || mRealmInstance.isClosed()) {
            mRealmInstance = Realm.getDefaultInstance();
        }
        return mRealmInstance;
    }

    public void saveQuotesResponseToRealm(RssFeed feed, String rssChannel) {
        Realm realm = Realm.getDefaultInstance();

        List<RssFeedItem> items = feed.getChannel().getItemList();

        for (RssFeedItem item:items) {
            RssItemRealm rssItemRealm =  new RssItemRealm(item, getOrderId(), rssChannel);
            realm.executeTransaction(realm1 -> realm1.insertOrUpdate(rssItemRealm)); //добавляем или обновляем rss item в транзакцию
        }

        realm.close();
    }


    public int getOrderId() {
        Realm realm = Realm.getDefaultInstance();
        try {
            orderId = realm.where(RssItemRealm.class).max("id").intValue() + 1;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            orderId = 0;
        }
        realm.close();
        return orderId;
    }
}
