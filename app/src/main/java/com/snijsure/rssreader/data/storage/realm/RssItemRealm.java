package com.snijsure.rssreader.data.storage.realm;

import com.snijsure.rssreader.data.network.model.RssFeedItem;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RssItemRealm extends RealmObject {
    @PrimaryKey
    private int id;
    private String title;
    private String publicationDate;
    private String description;
    private String channel;

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public RssItemRealm() {
    }

    public RssItemRealm(RssFeedItem item, int itemId, String rssChannel) {
        id = itemId;
        title = item.getTitle();
        publicationDate = item.getPublicationDate();
        description = item.getDescription();
        channel = rssChannel;
    }

    public int getId() {
        return id;
    }

    public String getChannel() {
        return channel;
    }
}
