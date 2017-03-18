package com.snijsure.rssreader.data.network.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "item", strict = false)
public class RssFeedItem implements Serializable {
    @Element(name = "title", required = true )
    private String title;

    @Element(name = "pubDate", required = true )
    private String publicationDate;

    @Element(name = "description", required = true )
    private String description;

//    @Element(name = "link")
//    private String link;
//
//    public String getLink() {
//        return link;
//    }

    public RssFeedItem(String title, String description, String publicationDate) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
    }
    public RssFeedItem() {}



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public boolean isEqualTo(RssFeedItem o) {
        if (o.getTitle().equals(title) &&
                o.getDescription().equals(description) &&
                o.getPublicationDate().equals(publicationDate)) {
            return true;
        }
        else
            return false;
    }

}
