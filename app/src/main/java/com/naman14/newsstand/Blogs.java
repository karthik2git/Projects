package com.naman14.newsstand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Blogs extends Activity {

    CustomListAdapter adapter;
    String url;
    List<BlogBean> blogs = new ArrayList<BlogBean>();
    public  String img;
    private String blimgUrl;

    ListView lvBlog;
    private ProgressDialog pDialog;
    private static final String TAG = Blogs.class.getSimpleName();
    String link;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
         lvBlog = (ListView) findViewById(R.id.lvSBlog);
        intent=getIntent();
        int i=intent.getIntExtra("pos",0);
         adapter = new CustomListAdapter(this, blogs);
         lvBlog.setAdapter(adapter);


        if(i==0)
          url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=89";
        if(i==1)
            url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=90";
        if(i==2)
            url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=88";
        if(i==3)
            url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=5";
        if(i==4)
            url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=1";
        if(i==5)
            url="https://www.3esofttech.com/wp-json/wp/v2/posts?categories=87";

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        //lvBlog.setItemsCanFocus(true);

        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        //Log.d("volleyup", "onResponse() " + jsonArray);
                        Log.d(TAG, jsonArray.toString());
                        hidePDialog();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {

                                JSONObject obj = jsonArray.getJSONObject(i);
                                Log.d("obj", "obj" + obj);
                                 BlogBean blog = new BlogBean();
                                blog.setTitle(obj.getJSONObject("title").getString("rendered"));
                                blog.setContent(obj.getJSONObject("excerpt").getString("rendered"));
                               //Getting url for image
                               JSONArray media = obj.getJSONObject("_links").getJSONArray("wp:featuredmedia");
                                for (int j = 0; j < media.length(); j++)
                                 {
                                    JSONObject childJSONObject = media.getJSONObject(j);
                                    link = childJSONObject.getString("href");
                                 }
                                imgUrl(link,blog);
                                blogs.add(blog);
                              }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }

                        adapter.notifyDataSetChanged();
                        //end of try

                        // adapter.notifyDataSetChanged();
                    }
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

        lvBlog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {

                BlogBean blogBean = blogs.get(position);
                String imageLink = blogBean.getUrl();
                intent=new Intent(getApplicationContext(),Blog.class);
                intent.putExtra("pos",position);
                intent.putExtra("url", url);
                 intent.putExtra("img",imageLink);
                startActivity(intent);
            }
        });
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
                            blimgUrl = null;
                            blimgUrl = response.getJSONObject("guid").getString("rendered");
                            Log.d("Blogs class", blimgUrl);

                            blog.setUrl(blimgUrl);
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

    public void setBlimgUrl(String blimgUrl) {
        this.blimgUrl = blimgUrl;
    }

    public String getBlimgUrl() {
        return blimgUrl;
    }

}
