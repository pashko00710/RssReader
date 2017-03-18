package com.snijsure.rssreader.data.network.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "rss", strict = false)
public class RssFeed implements Serializable {

    @Attribute
    private String version;

    @Element
    private RssChannel channel;

    public RssChannel getChannel() {
        return channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setChannel(RssChannel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "RssFeed{" +
                "version='" + version + '\'' +
                ", channel=" + channel +
                '}';
    }
}