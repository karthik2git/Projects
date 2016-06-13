package com.naman14.newsstand;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.etiennelawlor.imagegallery.library.activities.FullScreenImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.adapters.FullScreenImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.naman14.newsstand.view.PaletteTransformation;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import java.util.ArrayList;

public class Team3EActivity extends Activity implements ImageGalleryAdapter.ImageThumbnailLoader, FullScreenImageGalleryAdapter.FullScreenImageLoader {
    // region Member Variables
    private PaletteColorType mPaletteColorType;
     // endregion
    View view=null;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team3_e);
        ButterKnife.bind(this);

        ImageGalleryActivity.setImageThumbnailLoader(this);
        FullScreenImageGalleryActivity.setFullScreenImageLoader(this);

        // optionally set background color using Palette for full screen images
        mPaletteColorType = PaletteColorType.VIBRANT;
        onViewGallerySelected(view);
    }

    public void onViewGallerySelected(View view) {
        Intent intent = new Intent(this, ImageGalleryActivity.class);

        ArrayList<String> images = new ArrayList<>();


        //String str = Uri.parse("android.resource://com.naman14.newsstand/drawable/akshay.jpg").toString();

        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/Akshay-mocg2chcu02oeuq7h80tdda31xfmkm4o5zwf77z8r0.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/Anmol-mocfj7hnofvi0oj08g7a3p57mhrkuh5f79pifectfw.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/2015/10/Chandan-169x300.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/Sir-mocenrrz3wu9q66vsv0gpmq8ekpnewcljo8wm8ytjg.png");
        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/C360_2015-10-15-22-34-38-900-2-mociwyj2wwjjudoeaksmkh3lm7o4v3hs9vqn8nu1ho.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/2015/10/Jayanthi.png");
        images.add("https://www.3esofttech.com/wp-content/uploads/2015/10/Nagendra.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/2015/10/Pavan.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/2015/10/Satish.jpg");
        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/Untitled-2-mocfz8mk8ptk198omdo7mni8d2qy4msm2m9n3al3bg.png");
        images.add("https://www.3esofttech.com/wp-content/uploads/bfi_thumb/Veer-mocgyyhry2pt7tcw1thudn0t06p2mklezepvltmivg.png");
      /*  images.add("https://images.unsplash.com/photo-1429091967365-492aaa5accfe?q=80&fm=jpg&s=b7430cfe5508430aea39fcf3b0645878");
        images.add("https://images.unsplash.com/photo-1430132594682-16e1185b17c5?q=80&fm=jpg&s=a70abbfff85382d11b03b9bbc71649c3");
        images.add("https://images.unsplash.com/photo-1436891620584-47fd0e565afb?q=80&fm=jpg&s=33cf5b0ee9fbd292475a0c03bee481c9");

        images.add("https://images.unsplash.com/photo-1415871989540-61fe9268d3c8?q=80&fm=jpg&s=061a03a7abe860a6c165cc3994feaba2");
        images.add("https://images.unsplash.com/photo-1415033523948-6c31d010530d?q=80&fm=jpg&s=ebe77e93f095b1a21ff6f090d332a815");
        images.add("https://images.unsplash.com/photo-1415201179613-bd037ff5eb29?q=80&fm=jpg&s=46a25087049ca6bdcff8390a342b9c59");
        images.add("https://images.unsplash.com/photo-1418227165283-1595d13726cd?q=80&fm=jpg&s=45b1869e9cd4fce23510ded9370e3966");
        images.add("https://images.unsplash.com/photo-1416949929422-a1d9c8fe84af?q=80&fm=jpg&s=ba414d9605af43b67d974182756cfb1d");
        images.add("https://images.unsplash.com/reserve/JaI1BywIT5Or8Jfmci1E_zakopane.jpg?q=80&fm=jpg&s=57142c70a82dc560fc67ce09c12a6052");
        images.add("https://images.unsplash.com/uploads/141362941583982a7e0fc/abcfbca1?q=80&fm=jpg&s=4f36891ccddbd86ed034d5943fb0eccb");
        images.add("https://images.unsplash.com/uploads/14116941824817ba1f28e/78c8dff1?q=80&fm=jpg&s=5600be7f06b56681c56f55c787128538");
        images.add("https://images.unsplash.com/photo-1413977886085-3bbbf9a7cf6e?q=80&fm=jpg&s=bc09d3becea6f665b39290475f3467c8");
        images.add("https://images.unsplash.com/photo-1415226194219-638f50c5d25f?q=80&fm=jpg&s=4f3f71caf6caeb5d4f508a001111e480");

        images.add("https://images.unsplash.com/photo-1416934625760-d56f5e79f6fe?q=80&fm=jpg&s=4c526b15bda8434c6f9e7eefe12b29be");
        images.add("https://images.unsplash.com/uploads/141220211075617c40312/e2ddba22?q=80&fm=jpg&s=394885b1c8da6776e79815e961118c81");
        images.add("https://images.unsplash.com/uploads/1412238370909393b4a19/79f023f1?q=80&fm=jpg&s=95844dfcd1993f4f0b10eab82c183631");
        images.add("https://images.unsplash.com/reserve/OQx70jjBSLOMI5ackhxm_urbex-ppc-030.jpg?q=80&fm=jpg&s=821aacb41fc9d3a94e5263d58dccce80");
        images.add("https://images.unsplash.com/39/yvDPJ8ZSmSVob7pRxIvU_IMG_40322.jpg?q=80&fm=jpg&s=30b5834ad1c403bcfd7fa5c4dfaba625");
        images.add("https://images.unsplash.com/22/one-scene.JPG?q=80&fm=jpg&s=b8b57577424cdf5545bb11bdf6f4b5a7");
        images.add("https://images.unsplash.com/36/e6mVuK2jQlWxKt3eAnQT_image.jpg?q=80&fm=jpg&s=0a3d8da572b0ed5e0cb963f6fa13588a");
        images.add("https://images.unsplash.com/41/pHyYeNZMRFOIRpYeW7X3_manacloseup%20copy.jpg?q=80&fm=jpg&s=99f2dbdf1526488a93d3cf307dea43d6");
        images.add("https://images.unsplash.com/44/MIbCzcvxQdahamZSNQ26_12082014-IMG_3526.jpg?q=80&fm=jpg&s=9f2b7926c5c13f719c57536392d78b49");
        images.add("https://images.unsplash.com/photo-1415226556993-1404e0c6e727?q=80&fm=jpg&s=334b8b5271cdbd8cbd4990a3aef89074");*/

       intent.putStringArrayListExtra("images", images);
        //intent.putExtra("images",web);
        intent.putExtra("title", "Team 3E");

        startActivity(intent);
        finish();
    }
    @Override
    public void loadImageThumbnail(ImageView iv, String imageUrl, int dimension) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(dimension, dimension)
                    .centerCrop()
                    .into(iv);
        } else {
            iv.setImageDrawable(null);
        }
    }
    // endregion

    // region FullScreenImageGalleryAdapter.FullScreenImageLoader

    @Override
    public void loadFullScreenImage(ImageView iv, String imageUrl, int width, final LinearLayout bglinearLayout) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(width, 0)
                    .transform(PaletteTransformation.instance())
                    .into(iv, new PaletteTransformation.PaletteCallback(iv) {
                        @Override
                        public void onError() {

                        }

                        @Override
                        public void onSuccess(Palette palette) {
                            int bgColor = getBackgroundColor(palette);
                            if (bgColor != -1)
                                bglinearLayout.setBackgroundColor(bgColor);
                        }
                    });
        } else {
            iv.setImageDrawable(null);
        }
    }

    // endregion

    // region Helper Methods
    private int getBackgroundColor(Palette palette) {
        int bgColor = -1;

        int vibrantColor = palette.getVibrantColor(0x000000);
        int lightVibrantColor = palette.getLightVibrantColor(0x000000);
        int darkVibrantColor = palette.getDarkVibrantColor(0x000000);

        int mutedColor = palette.getMutedColor(0x000000);
        int lightMutedColor = palette.getLightMutedColor(0x000000);
        int darkMutedColor = palette.getDarkMutedColor(0x000000);

        if (mPaletteColorType != null) {
            switch (mPaletteColorType) {
                case VIBRANT:
                    if (vibrantColor != 0) { // primary option
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) { // fallback options
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case LIGHT_VIBRANT:
                    if (lightVibrantColor != 0) { // primary option
                        bgColor = lightVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case DARK_VIBRANT:
                    if (darkVibrantColor != 0) { // primary option
                        bgColor = darkVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case MUTED:
                    if (mutedColor != 0) { // primary option
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) { // fallback options
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case LIGHT_MUTED:
                    if (lightMutedColor != 0) { // primary option
                        bgColor = lightMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case DARK_MUTED:
                    if (darkMutedColor != 0) { // primary option
                        bgColor = darkMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                default:
                    break;
            }
        }

        return bgColor;
    }
}
