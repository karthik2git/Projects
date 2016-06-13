package com.naman14.newsstand;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends ActionBarActivity implements ScrollTabHolder, ViewPager.OnPageChangeListener, NavigationView.OnNavigationItemSelectedListener {

    private static AccelerateDecelerateInterpolator sSmoothInterpolator = new AccelerateDecelerateInterpolator();
    private View mHeader;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private Toolbar toolbar;
    private TextView title;
    private ImageView icon;
    private int mActionBarHeight;
    private int mMinHeaderHeight;
    private int mHeaderHeight;
    private int mMinHeaderTranslation;
    private ImageView mHeaderLogo;
    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();
    private TypedValue mTypedValue = new TypedValue();
    private SpannableString mSpannableString;
    private AlphaForegroundColorSpan mAlphaForegroundColorSpan;

    int[] photos={R.drawable.demo, R.drawable.blogs,R.drawable.photo3};
    KenBurnsView imageView;
    ImageView transparentImage;

//    private DrawerLayout drawerLayout;
//    private ListView drawerListView;
//    ActionBarDrawerToggle actionBarDrawerToggle;
//    FragmentManager fragmentManager;
//    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMinHeaderHeight = getResources().getDimensionPixelSize(R.dimen.min_header_height);
        mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
        mMinHeaderTranslation = -mMinHeaderHeight + getActionBarHeight()+80;

        setContentView(R.layout.activity_main);
        imageView =(KenBurnsView) findViewById(R.id.header_picture);
        transparentImage = (ImageView)findViewById(R.id.transparentImage);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        icon = (ImageView) findViewById(R.id.icon);
        title = (TextView) findViewById(R.id.title);
        mSpannableString = new SpannableString(getString(R.string.actionbar_title));

        mHeaderLogo = (ImageView) findViewById(R.id.header_thumbnail);
        mHeader = findViewById(R.id.header);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(4);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.setTabHolderScrollingContent(this);
        mViewPager.setAdapter(mPagerAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        mPagerSlidingTabStrip.setOnPageChangeListener(this);
        mAlphaForegroundColorSpan = new AlphaForegroundColorSpan(0xffffffff);

        ViewHelper.setAlpha(getActionBarIconView(), 0f);
        //getSupportActionBar().setBackgroundDrawable(null);

        getSupportActionBar().hide();


//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerListView = (ListView) findViewById(R.id.drawer_list);
//        List<String> list = new ArrayList<String>();
//        list.add("asdf");
//        list.add("sdfadfsa");
//        list.add("dsagfdffad");
//        drawerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, android.R.id.text1, list);
//        drawerListView.setAdapter(adapter);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_open,R.string.drawer_close);
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        fragmentManager = getSupportFragmentManager();
//        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                loadSelection(i);
//                drawerLayout.closeDrawer(drawerListView);
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //To find the header view and set their values
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);




//Used for multiple images on the header with animation.
//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i=0;
//            public void run() {
//                // change images randomly
//                Random ran=new Random();
//                int i=ran.nextInt(photos.length);
//                //set image resources
//                imageView.setImageResource(photos[i]);
//                i++;
//                if(i>photos.length-1)
//                {
//                    i=0;
//                }
//                handler.postDelayed(this, 5000);  //for interval...
//            }
//        };
//        handler.postDelayed(runnable, 5000); //for initial delay..


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        //actionBarDrawerToggle.syncState();
    }

//    public void loadSelection(int i){
//        drawerListView.setItemChecked(i, true);
//        switch (i){
//            case 0:
//                ManageTasks manageTasks = new ManageTasks();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, manageTasks);
//                fragmentTransaction.commit();
//                break;
//
//            case 1:
//                ManageTasks manageTasks1 = new ManageTasks();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, manageTasks1);
//                fragmentTransaction.commit();
//                break;
//            case 2:
//                ManageTasks manageTasks2 = new ManageTasks();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, manageTasks2);
//                fragmentTransaction.commit();
//                break;
//
//        }
//    }




    @Override
    public void onPageScrollStateChanged(int arg0) {
        // nothing
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // nothing
    }

    @Override
    public void onPageSelected(int position) {
        SparseArrayCompat<ScrollTabHolder> scrollTabHolders = mPagerAdapter.getScrollTabHolders();
        ScrollTabHolder currentHolder = scrollTabHolders.valueAt(position);
        currentHolder.adjustScroll((int) (mHeader.getHeight() + ViewHelper.getTranslationY(mHeader)),(int)(mHeaderHeight));


        if(position==0){
            imageView.setImageResource(R.drawable.photo3);
            transparentImage.setImageResource(R.color.blue_transparent);
        }
        if(position==1) {
            imageView.setImageResource(R.drawable.company);
            transparentImage.setImageResource(R.color.red_transparent);
        }
        if(position==2) {
            imageView.setImageResource(R.drawable.solutions);
            transparentImage.setImageResource(R.color.green_transparent);
        }
        if(position==3) {
            imageView.setImageResource(R.drawable.services);
            transparentImage.setImageResource(R.color.orange_transparent);
        }
        if(position==4) {
            imageView.setImageResource(R.drawable.demo);
            transparentImage.setImageResource(R.color.purple_transparent);
        }
        if(position==5) {
            imageView.setImageResource(R.drawable.blogs);
            transparentImage.setImageResource(R.color.black_transparent);
        }

    }

    @Override
    public void onScroll(ScrollView view, int x, int y, int oldX, int oldY, int pagePosition)
    {
        if (mViewPager.getCurrentItem() == pagePosition)
        {
            mHeader.setTranslationY(Math.max(-view.getScrollY(), mMinHeaderTranslation));
            float ratio = clamp(mHeader.getTranslationY() / mMinHeaderTranslation, 0.0f, 1.0f);
            interpolate(mHeaderLogo, getActionBarIconView(), sSmoothInterpolator.getInterpolation(ratio));
            setTitleAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
        }
    }

    @Override
    public void adjustScroll(int scrollHeight,int headerTranslationY) {
        // nothing
    }



    public static float clamp(float value, float max, float min) {
        return Math.max(Math.min(value, min), max);
    }

    private void interpolate(View view1, View view2, float interpolation) {
        getOnScreenRect(mRect1, view1);
        getOnScreenRect(mRect2, view2);

        float scaleX = 1.0F + interpolation * (mRect2.width() / mRect1.width() - 1.0F);
        float scaleY = 1.0F + interpolation * (mRect2.height() / mRect1.height() - 1.0F);
        float translationX = 0.5F * (interpolation * (mRect2.left + mRect2.right - mRect1.left - mRect1.right));
        float translationY = 0.5F * (interpolation * (mRect2.top + mRect2.bottom - mRect1.top - mRect1.bottom));

        ViewHelper.setTranslationX(view1, translationX);
        ViewHelper.setTranslationY(view1, translationY - ViewHelper.getTranslationY(mHeader));
        ViewHelper.setScaleX(view1, scaleX);
        ViewHelper.setScaleY(view1, scaleY);
    }

    private RectF getOnScreenRect(RectF rect, View view) {
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        return rect;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public int getActionBarHeight() {
        if (mActionBarHeight != 0) {
            return mActionBarHeight;
        }

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){
            getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue, true);
        } else {
            getTheme().resolveAttribute(R.attr.actionBarSize, mTypedValue, true);
        }

        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, getResources().getDisplayMetrics());

        return mActionBarHeight;
    }

    private void setTitleAlpha(float alpha) {
        mAlphaForegroundColorSpan.setAlpha(alpha);
        mSpannableString.setSpan(mAlphaForegroundColorSpan, 0, mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(mSpannableString);
//        title.setText("3E Software Solutions");
//        title.setTextColor(Color.WHITE);
    }

    private ImageView getActionBarIconView() {
        return icon;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, Team3EActivity.class);
            startActivity(intent);
        }
        /*else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*/
         else if (id == R.id.nav_share) {
            //create the send intent
            Intent shareIntent =new Intent(android.content.Intent.ACTION_SEND);

//set the type
            shareIntent.setType("text/plain");

//add a subject
            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Insert Subject Here");

//build the body of the message to be shared
            String shareMessage = "Insert message body here.";

//add the message
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    shareMessage);

//start the chooser for sharing
            startActivity(Intent.createChooser(shareIntent,"Insert share chooser title here"));

        }
        /*else if (id == R.id.nav_send) {
            Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
            startActivity(intent);

        }*/
        else if (id == R.id.contactus){
            Intent intent = new Intent(MainActivity.this, ContactUsList.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class PagerAdapter extends FragmentPagerAdapter {

        private SparseArrayCompat<ScrollTabHolder> mScrollTabHolders;
        private final String[] TITLES = { "Home", "Company", "Solutions", "Services", "Demos", "Blogs"};
        //private final String[] TITLES = { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jellybean","Kitkat","Lollipop"};
        private ScrollTabHolder mListener;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            mScrollTabHolders = new SparseArrayCompat<ScrollTabHolder>();
        }

        public void setTabHolderScrollingContent(ScrollTabHolder listener) {
            mListener = listener;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {

            ScrollTabHolderFragment fragment = (ScrollTabHolderFragment) ScrollViewFragment.newInstance(position);
            mScrollTabHolders.put(position, fragment);
            if (mListener != null) {
                fragment.setScrollTabHolder(mListener);
            }
            return fragment;
        }

        public SparseArrayCompat<ScrollTabHolder> getScrollTabHolders() {
            return mScrollTabHolders;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        if(id==R.id.action_settings){
//            return true;
//        }else if(id == android.R.id.home){
//            if(drawerLayout.isDrawerOpen(drawerListView))
//                drawerLayout.closeDrawer(drawerListView);
//            else
//                drawerLayout.openDrawer(drawerListView);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}