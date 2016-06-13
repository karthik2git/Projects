package com.naman14.newsstand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Blog extends Activity {
    private ProgressDialog pDialog;
    private static final String TAG = Blogs.class.getSimpleName();
    private WebView wv;
    TextView wh;
   // private NetworkImageView img;
    String contentUrl,imgUrl,link;
    int position;
    //ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
       // wv.loadDataWithBaseURL("", data1, "text/html", "UTF-8", "");
       wh=(TextView)findViewById(R.id.wHeading);
        //img=(NetworkImageView)findViewById(R.id.bImage);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        Intent intent=getIntent();
        contentUrl=intent.getStringExtra("url");
        position=intent.getIntExtra("pos", 0);
        imgUrl=intent.getStringExtra("img");
        Log.d("BLOGGG","url of img"+imgUrl);

//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();
//        img.setImageUrl(imgUrl,imageLoader);

        JsonArrayRequest request = new JsonArrayRequest(contentUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        //Log.d("volleyup", "onResponse() " + jsonArray);
                        Log.d(TAG, jsonArray.toString());
                        hidePDialog();

                      //  for (int i = 0; i < jsonArray.length(); i++) {
                            try {

                                JSONObject obj = jsonArray.getJSONObject(position);
                               //obj.getJSONObject("content").getString("rendered");
                                //wh.loadDataWithBaseURL("", obj.getJSONObject("title").getString("rendered"), "text/html", "UTF-8", "");
                                String temp = obj.getJSONObject("title").getString("rendered");
                                Spanned htmlAsSpanned = Html.fromHtml(temp);
                                wh.setText(htmlAsSpanned);
                                wv.loadDataWithBaseURL("", obj.getJSONObject("content").getString("rendered") , "text/html", "UTF-8", "");
                                JSONArray media = obj.getJSONObject("_links").getJSONArray("wp:featuredmedia");
                                for (int j = 0; j < media.length(); j++) {
                                    JSONObject childJSONObject = media.getJSONObject(j);
                                    link = childJSONObject.getString("href");


                                }
                                 imgUrl(imgUrl,new BlogBean());
                                }

                            catch (JSONException e) {
                                e.printStackTrace();

                            }
                           // }
                        }


                        //end of try

                        // adapter.notifyDataSetChanged();

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
                //error.printStackTrace();

            }

        }
        );

        AppController.getInstance().addToRequestQueue(request);

    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    public void imgUrl(String linkUrl, final BlogBean blog) {

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                linkUrl, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            imgUrl = response.getJSONObject("guid").getString("rendered");
                            Log.d("Blogs class",imgUrl);
                             blog.setUrl(imgUrl);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        AppController.getInstance().addToRequestQueue(jsonObjReq);



    }

}

