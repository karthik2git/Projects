package com.eeesoft.eeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by roshu on 30/4/16.
 */
public class ContactUsList extends AppCompatActivity implements View.OnClickListener {

    TextView call;
    //  CardView hello3e;
    CardView facebook;
    CardView twitter;
    CardView linkedIn;
    CardView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_list);

        getSupportActionBar().hide();

        call = (TextView) findViewById(R.id.call);
        // hello3e = (CardView) findViewById(R.id.twitter);
        facebook = (CardView) findViewById(R.id.facebook);
        twitter = (CardView) findViewById(R.id.mail);
        linkedIn = (CardView) findViewById(R.id.linkedin);
        map = (CardView) findViewById(R.id.map);

        call.setOnClickListener(this);
        // hello3e.setOnClickListener(this);
        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        linkedIn.setOnClickListener(this);
        map.setOnClickListener(this);
//        hello3e.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == call.getId()) {

            //Toast.makeText(getApplicationContext(),"Calling",Toast.LENGTH_SHORT).show();

//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:9916832878"));
//
//          if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//              //  Log.d("Callintent", "" );
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//
//            }
//            startActivity(callIntent);

            String number = "9916832878";
            Uri call = Uri.parse("tel:" + number);
            Intent surf = new Intent(Intent.ACTION_DIAL, call);

            startActivity(surf);


        }
      /*  else if(v.getId() == hello3e.getId()){

//            Intent intent = new Intent(ContactUsList.this, ContactUs.class);
//            startActivity(intent);
           hello3e.setVisibility(View.INVISIBLE);
        }*/
        else if(v.getId() == facebook.getId()){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/software3e"));
            startActivity(i);

        }else if(v.getId() == twitter.getId()){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/software3e"));
            startActivity(i);

        }else if(v.getId() == linkedIn.getId()){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/software3e"));
            startActivity(i);

        }else if(v.getId() == map.getId()){
            Intent m=new Intent(ContactUsList.this,OnMaP.class);
            startActivity(m);
        }
    }
}
