package com.snijsure.rssreader.mvp.views;

import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.snijsure.rssreader.ui.adapters.RssItemAdapter;

public interface IMainView extends IView {

    RssItemAdapter getAdapter();

    void showRssItems();

    void startDetailActivity(RssItemRealm rssItem);
}
