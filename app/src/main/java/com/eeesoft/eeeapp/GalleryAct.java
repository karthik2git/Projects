package com.eeesoft.eeeapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;

public class GalleryAct extends Activity {
    GridView grid;
    String[] web = {
            "AKSHAY",
            "ANMOL",
            "CHANDAN",
            "FAIZ",
            "JAGADISH",
            "JAYANTHI",
            "NAGENDRA",
            "PAVAN",
            "SATHISH",
            "SURAJ",
            "VEERESH",
    } ;
    int[] imageId = {
            R.drawable.akshay,
            R.drawable.anmol,
            R.drawable.chandan,
            R.drawable.faiz,
            R.drawable.jagadish,
            R.drawable.jayanthi,
            R.drawable.nagendra,
            R.drawable.pavan,
            R.drawable.satish,
            R.drawable.suraj,
            R.drawable.veeresha,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        CustomGrid adapter = new CustomGrid(GalleryAct.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
//        onBackPressed();
    }

}
