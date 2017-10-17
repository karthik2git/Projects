package com.eeesoft.eeeapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Karthik on 6/7/2016.
 */
public class CustomAdapter extends BaseAdapter {


    String [] result;
    Context context;
     private static LayoutInflater inflater=null;
    public CustomAdapter(Activity mainActivity, String[] prgmNameList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
            }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.blog_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.txtBHeading);
        holder.tv.setText(result[position]);
       /*  rowView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });*/
        return rowView;
    }
}
