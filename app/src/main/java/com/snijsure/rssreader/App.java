package com.snijsure.rssreader;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class App extends Application {
    public static SharedPreferences sSharedPreferences;
    private static Context sContext;
    private static final long MAX_CONNECTION_TIMEOUT = 5000;
    private static final long MAX_READ_TIMEOUT = 5000;
    private static final long MAX_WRITE_TIMEOUT = 5000;
    public static final String BASE_URL = "https://habrahabr.ru/rss/hubs/";

    @Override
    public void onCreate() {
        super.onCreate();


        Realm.init(this);
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());


        sContext = getApplicationContext();
        sSharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

    public static Context getContext() {return sContext;}

    public static Retrofit createRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(MAX_CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(MAX_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(MAX_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

//    private Converter.Factory createConvertFactory() {
//        return GsonConverterFactory.create(new Moshi.Builder()
//                //.add(new CommentJsonAdapter()) //this error 1:40
//                .build());
//    }
}
