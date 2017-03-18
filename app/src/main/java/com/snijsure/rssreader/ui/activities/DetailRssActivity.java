package com.snijsure.rssreader.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.snijsure.rssreader.R;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class DetailRssActivity extends AppCompatActivity {
    String rssItemTitle, rssItemDescription, rssItemDate, rssItemImage;
    Bundle bundle;
    Document doc;

    TextView textViewPubDate, textViewTitle, textViewDescription;
    ImageView imageViewTitle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rss);

        textViewPubDate = (TextView) findViewById(R.id.textview_pubdate);
        textViewTitle = (TextView) findViewById(R.id.textview_title);
        textViewDescription = (TextView) findViewById(R.id.textview_desc);
        imageViewTitle = (ImageView) findViewById(R.id.imageview_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        initToolbar();



        bundle = this.getIntent().getExtras();
        rssItemTitle = bundle.getString("rssItemTitle");
        rssItemDescription = bundle.getString("rssItemDescription");
        rssItemDate = bundle.getString("rssItemDate");
        rssItemImage = bundle.getString("rssItemImage");
        doc = Parser.parse(rssItemDescription ,"");


        textViewPubDate.setText(rssItemDate);
        textViewTitle.setText(rssItemTitle);
        textViewDescription.setText(doc.body().text());
        Picasso.with(this)
                .load(rssItemImage)
//                .placeholder(R.drawable.user_placeholder)
//                .error(R.drawable.user_placeholder_error)
                .into(imageViewTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startMainActivity(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
