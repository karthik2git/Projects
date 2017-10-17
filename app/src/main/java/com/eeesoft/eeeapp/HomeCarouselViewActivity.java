package com.eeesoft.eeeapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeCarouselViewActivity extends Activity {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.extendware, R.drawable.mirasvit, R.drawable.msg91, R.drawable.payumoney, R.drawable.innoexts,R.drawable.magictoolbox,R.drawable.instamojo,R.drawable.kapsystems,R.drawable.wisdmlabs};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_carousel_view);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
