package com.snijsure.rssreader.mvp.presenters;

import android.support.annotation.Nullable;

import com.snijsure.rssreader.mvp.views.IView;

public abstract class AbstractPresenter<T extends IView> {
    public static String TAG = "AbstractPresenter";

    private T mView;

    public void takeView(T view) {
        mView = view;
    }

    public void dropView() {
        mView = null;
    }

    public abstract void initView(String channel);

    @Nullable
    public T getView() {
        return mView;
    }
}
