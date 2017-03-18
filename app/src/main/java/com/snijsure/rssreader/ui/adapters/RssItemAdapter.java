package com.snijsure.rssreader.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.snijsure.rssreader.R;
import com.snijsure.rssreader.data.storage.realm.RssItemRealm;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class RssItemAdapter extends RecyclerView.Adapter<RssItemAdapter.RssItemHolder> {
    private static final String TAG="RssItemAdapter";
    private List<RssItemRealm> rssFeedItems = new ArrayList<>();
    private RssItemHolder.OnClickListener mListener;
    private Context mContext;

    public RssItemAdapter() {

    }

    public RssItemAdapter(RssItemHolder.OnClickListener listener, Context context) {
        this.mListener = listener;
        mContext = context;
    }

    @Override
    public RssItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        final View v = layoutInflater.inflate(R.layout.rss_feed_item, viewGroup, false);
        return new RssItemHolder(v, mListener);
    }

    @Override
    public int getItemCount() {
        return rssFeedItems.size();
    }

    public void clearData() {
        // clear the data
        rssFeedItems.clear();
        notifyDataSetChanged();
    }

    public void addItem(RssItemRealm product) {
        Log.e(TAG, "addItem: "+product.getTitle());
        rssFeedItems.add(product);
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final RssItemHolder holder, int pos) {

        RssItemRealm item = rssFeedItems.get(pos);

        holder.mRssItem = item;

        holder.titleTextField.setText(item.getTitle());
        Document doc = Parser.parse(item.getDescription(),"");
        Element imageElement = doc.select("img").first();
        if ( imageElement != null ) {
            String absoluteUrl = imageElement.absUrl("src");
            if (absoluteUrl != null) {
//                UrlImageViewHelper.setUrlDrawable(holder.imageView, absoluteUrl,
//                        android.R.drawable.gallery_thumb);
                Picasso.with(mContext)
                        .load(absoluteUrl)
                .placeholder(android.R.drawable.gallery_thumb)
                .error(android.R.drawable.gallery_thumb)
                        .into(holder.imageView);
                holder.descriptionTextField.setText(doc.body().text());
            }
        } else {
            Picasso.with(mContext)
                    .load("http://vignette2.wikia.nocookie.net/steamplane/images/b/b0/Happy_Face_100x100.gif/revision/latest?cb=20120104232844")
                    .placeholder(android.R.drawable.gallery_thumb)
                    .error(android.R.drawable.gallery_thumb)
                    .into(holder.imageView);
        }
        holder.publicationDateTextField.setText(item.getPublicationDate());
    }

    public static class RssItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleTextField;
        private TextView descriptionTextField;

        private ImageView imageView;
        private TextView publicationDateTextField;
        private RelativeLayout relativeWrapper;

        public RssItemRealm mRssItem;

        private RssItemHolder.OnClickListener mClickListener;
        RssItemHolder(View itemView, OnClickListener clickListener) {
            super(itemView);
            titleTextField = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            descriptionTextField = (TextView) itemView.findViewById(R.id.description);
            publicationDateTextField = (TextView) itemView.findViewById(R.id.pubdate);
            relativeWrapper = (RelativeLayout) itemView.findViewById(R.id.relative_wrapper);
            mClickListener = clickListener;

            relativeWrapper.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                switch (v.getId()) {
                    case R.id.relative_wrapper:
                        mClickListener.onCardClick(mRssItem);
                        break;
                }
            }
        }


        public interface OnClickListener {
            void onCardClick(RssItemRealm rssItem);
        }
    }
}
