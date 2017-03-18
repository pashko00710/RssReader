package com.snijsure.rssreader.mvp.presenters;

import android.util.Log;

import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.snijsure.rssreader.mvp.models.MainModel;
import com.snijsure.rssreader.mvp.views.IMainView;
import com.snijsure.rssreader.ui.adapters.RssItemAdapter;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter extends AbstractPresenter<IMainView> {
    private static MainPresenter outInstance;
    private MainModel mModel;
    protected CompositeSubscription mCompositeSubscription;
    Subscription rssItems;
    Observable<RssItemRealm> items;

    public MainPresenter() {
        mModel = new MainModel();
        mCompositeSubscription = new CompositeSubscription();
    }

    public static MainPresenter getInstance() {
        if(outInstance == null) {
            outInstance = new MainPresenter();
        }
        return outInstance;
    }

    @Override
    public void initView(String channel) {
        mCompositeSubscription.add(subscribeOnRssItemRealmObs(channel));
    }

    @Override
    public void dropView() {
        if(mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
        super.dropView();
    }

    public Subscription subscribeOnRssItemRealmObs(String channel) {
        rssItems = mModel.getRssItemsObs(channel)
                .limit(25)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RealmSubscriber());

        getView().showRssItems();
        return rssItems;



    }

    public void onRssCardClick(RssItemRealm rssItem) {
        getView().startDetailActivity(rssItem);
    }

    private class RealmSubscriber extends Subscriber<RssItemRealm> {
        RssItemAdapter mAdapter = getView().getAdapter();

        @Override
        public void onCompleted() {
            Log.e("this", "onCompleted: ");
            mCompositeSubscription.remove(rssItems);
        }

        @Override
        public void onError(Throwable e) {
            Log.e("lul", "onError: "+e.getMessage());
        }

        @Override
        public void onNext(RssItemRealm productRealm) {
            Log.e("lul", "onNext: this"+productRealm.getId());
            mAdapter.addItem(productRealm);
//            if(mAdapter.getCount() -1 == lastPagerPosition) {
//                getRootView().hideLoad();
//            getView().showRssItems();
//            }
        }
    }
}
