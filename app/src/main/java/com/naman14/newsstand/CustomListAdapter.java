package com.naman14.newsstand;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Karthik on 6/2/2016.
 */
public class CustomListAdapter extends BaseAdapter {


    private Activity activity;
    private LayoutInflater inflater;
    private List<BlogBean> blogBeanList;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<BlogBean> blogBeanList) {
        this.activity = activity;
        this.blogBeanList =blogBeanList;
    }

    @Override
    public int getCount() {
        return blogBeanList.size();
    }

    @Override
    public Object getItem(int location) {
        return blogBeanList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.customblog, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
//        WebView tvTitle = (WebView) convertView.findViewById(R.id.tvTitle);
//        tvTitle.getSettings().setJavaScriptEnabled(true);
//        tvTitle.setFocusable(false);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

//        WebView tvRating = (WebView) convertView.findViewById(R.id.tvRating);
//        tvRating.getSettings().setJavaScriptEnabled(true);
//        tvRating.setFocusable(false);
        TextView tvRating = (TextView) convertView.findViewById(R.id.tvRating);

        NetworkImageView niv = (NetworkImageView) convertView.findViewById(R.id.imMovie);

        BlogBean blogBean = blogBeanList.get(position);

        //tvTitle.setText(String.valueOf(blogBean.getTitle()));
        //tvTitle.loadDataWithBaseURL("", String.valueOf(blogBean.getTitle()), "text/html", "UTF-8", "");
        String tempTitle = String.valueOf(blogBean.getTitle());
        Spanned htmlAsSpanned = Html.fromHtml(tempTitle);
        tvTitle.setText(htmlAsSpanned);

        //tvRating.setText(String.valueOf(blogBean.getContent()));
        //tvRating.loadDataWithBaseURL("", String.valueOf(blogBean.getContent()), "text/html", "UTF-8", "");
        String tempRating = String.valueOf(blogBean.getContent());
        Spanned htmlAsSpanned1 = Html.fromHtml(tempRating);
        tvRating.setText(htmlAsSpanned1);

        niv.setImageUrl(blogBean.getUrl(), imageLoader);



        return convertView;
    }





}
