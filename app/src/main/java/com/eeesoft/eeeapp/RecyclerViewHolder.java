package com.eeesoft.eeeapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Karthik on 5/25/2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1;
    WebView tv2;
    ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (WebView) itemView.findViewById(R.id.list_desc);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);

    }
}
