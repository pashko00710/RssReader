package com.snijsure.rssreader.data.network.errors;

public class NetworkAvailableError extends Throwable {
    public NetworkAvailableError() {
        super("Интернет недоступен, попробуйте позже");
    }
}