package com.snijsure.rssreader.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.snijsure.rssreader.R;
import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.snijsure.rssreader.mvp.presenters.MainPresenter;
import com.snijsure.rssreader.mvp.views.IMainView;
import com.snijsure.rssreader.ui.adapters.RssItemAdapter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;


public class MainActivity extends AppCompatActivity implements IMainView {
    RecyclerView rss_feed_list;
    private static String TAG = "MainActivity";
    RssItemAdapter mAdapter;
    MainPresenter mPresenter = MainPresenter.getInstance();
    RssItemAdapter.RssItemHolder.OnClickListener mListener = rssItem -> mPresenter.onRssCardClick(rssItem);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rss_feed_list = (RecyclerView)findViewById(R.id.rss_feed_list);
        mAdapter = new RssItemAdapter(mListener, this);

        mPresenter.takeView(this);
        mPresenter.initView("all");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         mAdapter.clearData();
        switch (item.getItemId()) {
            case R.id.all_items:
                mPresenter.initView("all");
                return true;
            case R.id.weekly_items:
                mPresenter.initView("weekly");
                return true;
            case R.id.monthly_items:
                mPresenter.initView("monthly");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showRssItems() {
        if (rss_feed_list != null) {
            rss_feed_list.setHasFixedSize(true);
        }
        LinearLayoutManager layoutMgr = new LinearLayoutManager(this);
        rss_feed_list.setLayoutManager(layoutMgr);
        rss_feed_list.setAdapter(mAdapter);
    }

    @Override
    public void startDetailActivity(RssItemRealm rssItem) {

        Document doc = Parser.parse(rssItem.getDescription(),"");
        Element imageElement = doc.select("img").first();
        String absoluteUrl = "";
        if ( imageElement != null ) {
            absoluteUrl = imageElement.absUrl("src");
        }



        Intent intent = new Intent(this, DetailRssActivity.class);
        intent.putExtra("rssItemTitle", rssItem.getTitle());
        intent.putExtra("rssItemDescription", rssItem.getDescription());
        intent.putExtra("rssItemDate", rssItem.getPublicationDate());
        intent.putExtra("rssItemImage", absoluteUrl);
        startActivity(intent);
        finish();
    }

    public RssItemAdapter getAdapter() {
        return mAdapter;
    }
}
