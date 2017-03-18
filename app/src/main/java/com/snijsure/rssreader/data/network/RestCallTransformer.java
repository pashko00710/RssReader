package com.snijsure.rssreader.data.network;

import android.util.Log;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.snijsure.rssreader.data.network.errors.ErrorUtils;
import com.snijsure.rssreader.utils.NetworkStatusChecker;
import com.snijsure.rssreader.data.network.errors.NetworkAvailableError;

import retrofit2.Response;
import rx.Observable;

public class RestCallTransformer<R> implements Observable.Transformer<Response<R>, R> {
    @Override
    @RxLogObservable
    public Observable<R> call(Observable<Response<R>> responseObservable) {
        return NetworkStatusChecker.isInternetAvialable()
                .flatMap(aBoolean -> aBoolean ? responseObservable : Observable.error(new NetworkAvailableError()))
                .flatMap(rResponse -> {
                    switch (rResponse.code()) {
                        case 200:
                            Log.e("this", "call: 200");
                            return Observable.just(rResponse.body());
                        case 304:
                            Log.e("this", "call: 304");
                            return Observable.empty();
                        default:
                            Log.e("this", "call: error");
                            return Observable.error(ErrorUtils.parseError(rResponse));
                    }
                });
    }
}
