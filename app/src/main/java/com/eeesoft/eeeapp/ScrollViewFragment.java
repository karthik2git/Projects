package com.eeesoft.eeeapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScrollViewFragment extends ScrollTabHolderFragment implements NotifyingScrollView.OnScrollChangedListener {
    //changes
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter mAdapter;
    //
    private static final String ARG_POSITION = "position";
    private NotifyingScrollView mScrollView;

    TextView title;
    TextView titleShortDescription;
    TextView titleDescription;
    TextView textSendEmail;
    TextView textContact;
    TextView textEmail;
    LinearLayout layout1;
    LinearLayout layout2;
    ImageView titleImage;

    private int mPosition;
    private CardView cardView,cardView2;
    private VideoView videoView;
    private ImageView videoReplayButton;
    TextView heading;
    ListView lb;
    ArrayAdapter<String> modeAdapter;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String companyHeader[]={"TEAM 3E", "HOBBY PROJECTS"};
    String companyTeam3e[]={"TEAM 3E"};
    String companyHobbyProjects[]={"HOBBY PROJECTS"};
    private String selected="";
    CarouselView carouselView;
    CarouselView carouselView1;
    LinearLayout linearLayout;
    int[] sampleImages = {R.drawable.payumoney, R.drawable.extendware, R.drawable.mirasvit, R.drawable.msg91, R.drawable.innoexts,R.drawable.magictoolbox,R.drawable.instamojo,R.drawable.kapsystems,R.drawable.wisdmlabs};
    int[] clientImages = {R.drawable.boab_services, R.drawable.boab_boats, R.drawable.brain_storm_consulting,R.drawable.dexter_talent_labs, R.drawable.divas};
    //String colors[]={"blue_ntransparent", "red_ntransparent","green_ntransparent","purple_ntransparent","black_ntransparent"};
    //String colors;
    int colors;
    View v;
    ArrayList<DataObject> data = new ArrayList<>();
    CheckConnectivity check = new CheckConnectivity();


    public static Fragment newInstance(int position) {
        ScrollViewFragment f = new ScrollViewFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(ARG_POSITION);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_scrollview, container, false);


        mScrollView = (NotifyingScrollView) v.findViewById(R.id.scrollview);
        mScrollView.setOnScrollChangedListener(this);

        linearLayout = (LinearLayout)v.findViewById(R.id.linearLayout);
        linearLayout.setVisibility(View.INVISIBLE);
        carouselView = (CarouselView) v.findViewById(R.id.carouselView);
        carouselView1 = (CarouselView) v.findViewById(R.id.carouselView1);

        layout1=(LinearLayout) v.findViewById(R.id.layout1);
        //layout2=(LinearLayout) v.findViewById(R.id.layout2);
        titleDescription =(TextView) v.findViewById(R.id.titleDescription);
        titleShortDescription = (TextView) v.findViewById(R.id.titleShortDescription);
        title = (TextView) v.findViewById(R.id.title);
        heading=(TextView)v.findViewById(R.id.heading);

        //textContact = (TextView) v.findViewById(R.id.textContact);
        //textEmail = (TextView) v.findViewById(R.id.textEmail);
        //textSendEmail = (TextView) v.findViewById(R.id.textSendEmail);

        videoView = (VideoView) v.findViewById(R.id.videoView);
        videoView.setVisibility(View.INVISIBLE);
        videoReplayButton = (ImageView) v.findViewById(R.id.videoReplaybutton);
        videoReplayButton.setVisibility(View.INVISIBLE);

        expListView = (ExpandableListView)v.findViewById(R.id.lvExp);
        lb=(ListView)v.findViewById(R.id.lvBlog);


//        textSendEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = textEmail.getText().toString();
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//                emailIntent.setType("text/plain");
//                emailIntent.setData(Uri.parse("mailto:"+email));
//                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(emailIntent);
//            }
//        });

        titleImage =(ImageView) v.findViewById(R.id.titleImage);
        cardView =(CardView) v.findViewById(R.id.cardView);

        cardView.setPadding(30, 30, 30, 30);

        cardView2=(CardView)v.findViewById(R.id.cardview2);
        //Changes
        //    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(mLayoutManager);
        //      mAdapter = new MyRecyclerViewAdapter(data);
        //  recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);

        if (mPosition==0){


            layout1.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            colors=getResources().getColor(R.color.black_ntransparent);
            //layout2.setBackgroundColor(getResources().getColor(R.color.blue_ntransparent));
            titleDescription.setText("Our Core values           :Profits Are Important.Principles are Essential.Solve Complex Problems for Our Customers.Keep Ourselves Simple and Nimble ");
            

            makeTextViewResizable(titleDescription,4,"View More",true);
            title.setText("We are 3E");
            titleShortDescription.setText("We love open source!");
            titleImage.setImageResource(R.color.blue_ntransparent);


            videoView.setVisibility(View.VISIBLE);
            videoReplayButton.setVisibility(View.VISIBLE);

            String videoPath = "android.resource://com.eee.eeeapp/" + R.raw.threeevideo;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

            videoReplayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String videoPath = "android.resource://com.eee.eeeapp/" + R.raw.threeevideo;
                    Uri uri = Uri.parse(videoPath);
                    videoView.setVideoURI(uri);
                    videoView.requestFocus();
                    videoView.start();
                }
            });

            //cardView2.setCardBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            heading.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            //Intent intent=new Intent(getActivity(),HomeCarouselViewActivity.class);
            //startActivity(intent);

            linearLayout.setVisibility(View.VISIBLE);
            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(sampleImages[position]);
                }
            };

            carouselView.setPageCount(sampleImages.length);
            carouselView.setImageListener(imageListener);

            ImageListener imageListener1 = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(clientImages[position]);
                }
            };

            carouselView1.setPageCount(clientImages.length);
            carouselView1.setImageListener(imageListener1);

        }
        if (mPosition==1) {

            layout1.setBackgroundColor(getResources().getColor(R.color.red_ntransparent));
            //layout2.setBackgroundColor(getResources().getColor(R.color.red_ntransparent));
            titleDescription.setText("3E Software Solutions is a Bangalore, India based IT Services Company, offering customized and specialized Web and Mobile based Software Development services. 3E also offers special domain expertise in developing eCommerce and eLearning solutions. We are well versed in building to Open Standards to enable Easy-to-Integrate Services for complete Solutions. The first guideline to our design methodology is “Every Customer comes with Unique Requirements”. Our motto is to work close with our customers in designing and implementing solutions that best aligns with their business requirements.");
            makeTextViewResizable(titleDescription, 4, "View More", true);
            title.setText("About Us");
            titleShortDescription.setText("Experts in e-Commerce & e-Learning");
            //    textContact.setText("Naman Dwivedi");
            // get the listview
           titleImage.setImageResource(R.drawable.company);
            heading.setBackgroundColor(getResources().getColor(R.color.red_ntransparent));
            // cardView2.setCardBackgroundColor(getResources().getColor(R.color.red_ntransparent));
            prepareListData();
            listAdapter = new ExpandableListAdapterN(getContext(), listDataHeader, listDataChild);
// setting list adapter
            expListView.setAdapter(listAdapter);
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
// Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                   /* Toast.makeText(getActivity(),
                            listDataHeader.get(groupPosition) + " Collapsed",
                            Toast.LENGTH_SHORT).show();*/

                }
            });
            colors=getResources().getColor(R.color.red_ntransparent);
            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    selected = (String) listAdapter.getChild(groupPosition, childPosition);
                    Intent intent=new Intent(getActivity(),Content.class);
                    intent.putExtra("pos",mPosition);
                    intent.putExtra("group",groupPosition);

                    intent.putExtra("child",childPosition);
                    intent.putExtra("heading",selected);
                    intent.putExtra("color",colors);
                    startActivity(intent);

               /*     // TODO Auto-generated method stub
                    Toast.makeText(getActivity(),
                            listDataHeader.get(groupPosition)
                                    + " : "
                                    + listDataChild.get(
                                    listDataHeader.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT)
                            .show();*/
                    return false;
                }
            });
        }
        if (mPosition==2) {

            layout1.setBackgroundColor(getResources().getColor(R.color.green_ntransparent));
            //layout2.setBackgroundColor(getResources().getColor(R.color.green_ntransparent));
            titleDescription.setText("3E Software Solutions offer a complete range of eCommerce Solutions for B2B and B2C sectors. With a broad focus on Open Source technologies and Open Standards, our Solutions and Services are customizable to Client specific requirements. Our eCommerce solutions range from Single Store website, to Multiple Store solutions to full-pledged Online MarketPlace deployments.\n" +
                    "\n" +
                    "Our expertise is in Development, Deployment, Integrations and Support for Magento™ and WooCommerce™ based solutions, with an emphasis on Scalable and High-Available solutions.");
            makeTextViewResizable(titleDescription, 4, "View More", true);
            title.setText("Ecommerce Solutions");
            //titleShortDescription.setText("Api level 5");
            titleImage.setImageResource(R.drawable.solutions);
            prepareListSolutions();
            // cardView2.setCardBackgroundColor(getResources().getColor(R.color.green_ntransparent));
            heading.setBackgroundColor(getResources().getColor(R.color.green_ntransparent));
            colors=getResources().getColor(R.color.green_ntransparent);
            listAdapter = new ExpandableListAdapterN(getContext(), listDataHeader, listDataChild);
// setting list adapter
            expListView.setAdapter(listAdapter);
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
// Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    // Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " Collapsed",Toast.LENGTH_SHORT).show();

                }
            });
            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    selected = (String) listAdapter.getChild(groupPosition, childPosition);

                    Intent intent = new Intent(getActivity(), Content.class);
                    intent.putExtra("pos", mPosition);
                    intent.putExtra("group",groupPosition);
                    intent.putExtra("child",childPosition);
                    intent.putExtra("heading",selected);
                    intent.putExtra("color",colors);
                    startActivity(intent);
                    Log.d("childPosition", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)+childPosition+groupPosition);
                    // TODO Auto-generated method stub
                    //      Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                    //            .show();
                    return false;
                }
            });
        }
        if (mPosition==3) {
            layout1.setBackgroundColor(getResources().getColor(R.color.orange_ntransparent));
            //layout2.setBackgroundColor(getResources().getColor(R.color.orange_ntransparent));
            titleDescription.setText("We provide pre-implementation LMS consulting services to our Clients.\n" +
                    "\n" +
                    "We provide expert advisory and consulting services on assessment of your eCommerce platform requirements. We engage our eCommerce Development team, comprised of eXpert Magento and WooCommerce Developers, to work closely with our Clients to understand their Shortterm and Longterm objectives of their planned eCommerce Site implementation and help you make informed decisions ranging from ‘Which Platform is the Right Choice for you’ to ‘Assessing the Technical Implementation choices with that Platform. This helps individuals and organizations who are getting started with their eCommerce site implementations but are new to eCommerce software (or eCommerce itself) or in ‘still evaluating’ the technical choices against their requirements.\n" +
                    "\n" +
                    "Our Assessment services also serve the Clients who already have made a decision to build on the platform or have already built their eCommerce site. Our eCommerce Consulting Services help them understand all the options they have with respect to Design, Functionality, Hosting and Integration with other Applications (ERP, CRM, Multi-Channel Commerce, Cloud Storage, …), Content Management Systems (WordPress, Joomla, …), eLearning Platforms for selling Online Courses, and Payment Gateways.");
            makeTextViewResizable(titleDescription, 4, "View More", true);
            title.setText("Ecommerce Services");
            titleShortDescription.setText("Ecommerce Assessment");
            titleImage.setImageResource(R.drawable.services);
            prepareListServices();
            // cardView2.setCardBackgroundColor(getResources().getColor(R.color.orange_ntransparent));
            heading.setBackgroundColor(getResources().getColor(R.color.orange_ntransparent));
            colors=getResources().getColor(R.color.orange_ntransparent);
            listAdapter = new ExpandableListAdapterN(getContext(), listDataHeader, listDataChild);
// setting list adapter
            expListView.setAdapter(listAdapter);
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
// Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    // Toast.makeText(getActivity(),listDataHeader.get(groupPosition) + " Collapsed",Toast.LENGTH_SHORT).show();

                }
            });
            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    selected = (String) listAdapter.getChild(
                            groupPosition, childPosition);
                    colors=getResources().getColor(R.color.orange_ntransparent);
                    Intent intent = new Intent(getActivity(), Content.class);
                    intent.putExtra("pos", mPosition);
                    intent.putExtra("group", groupPosition);
                    intent.putExtra("child", childPosition);
                    intent.putExtra("heading",selected);
                    intent.putExtra("color",colors);
                    startActivity(intent);
                    Log.d("childPosition", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + childPosition + groupPosition);
                    // TODO Auto-generated method stub
                    // Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                    //       .show();
                    return false;
                }
            });
        }
        if (mPosition==4) {
            layout1.setBackgroundColor(getResources().getColor(R.color.purple_ntransparent));
            //layout2.setBackgroundColor(getResources().getColor(R.color.purple_ntransparent));
            titleDescription.setText("Our Client Engagement Model: Discussions" + "( What is right for our Customer and their Customers)," + "Design "+ "( Technology Evaluation, Gap Analysis ), "+ "Development" + "( Iterative Development through Customer Engagement ),"+ "Deployment"+ " (Ready for Business ), "+ "Delivery"+ "( Make our Customer self-sufficient)");
            makeTextViewResizable(titleDescription, 4, "View More", true);
            title.setText("Demos");
            titleShortDescription.setText("Check Our Demos");
            titleImage.setImageResource(R.drawable.demos);
            //cardView2.setCardBackgroundColor(getResources().getColor(R.color.purple_ntransparent));
            prepareListDemos();
            heading.setBackgroundColor(getResources().getColor(R.color.purple_ntransparent));
            colors=getResources().getColor(R.color.orange_ntransparent);

            listAdapter = new ExpandableListAdapterN(getContext(), listDataHeader, listDataChild);
// setting list adapter
            expListView.setAdapter(listAdapter);
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
// Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    // Toast.makeText(getActivity(),listDataHeader.get(groupPosition) + " Collapsed",Toast.LENGTH_SHORT).show();

                }
            });
            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    selected = (String) listAdapter.getChild(
                            groupPosition, childPosition);
                    colors = getResources().getColor(R.color.purple_ntransparent);
                    Intent intent = new Intent(getActivity(), Content.class);
                    intent.putExtra("pos", mPosition);
                    intent.putExtra("group", groupPosition);
                    intent.putExtra("child", childPosition);
                    intent.putExtra("heading", selected);
                    intent.putExtra("color", colors);
                    startActivity(intent);
                    Log.d("childPosition", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + childPosition + groupPosition);
                    // TODO Auto-generated method stub
                    // Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                    //       .show();
                    return false;
                }
            });

        }
        if (mPosition==5) {
            layout1.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            //layout2.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            titleDescription.setText("Here we have excellent blogs on various technologies by our experties. \n" +
                    "Techonologies included are \"Agile Process\", \"eLearning\", \"eCommerce\", \n" +
                    "\"Desig\" etc. Help yourself by going through the blogs. \n" +
                    "\n");
            makeTextViewResizable(titleDescription, 4, "View More",true);
            title.setText("Blogs");
            titleShortDescription.setText("3E Blogs");
            heading.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            titleImage.setImageResource(R.drawable.blog_img);
            lb.setVisibility(View.VISIBLE);

            final String[] stringArray = new String[] { "AGILE PROCESS", "BUSINESS","DESIGN","ELEARNING","ECOMMERCE","TECH" };
            modeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1,stringArray);
            // Set the ArrayAdapter as the ListView's adapter.
            lb.setAdapter(modeAdapter);
            lb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    //  Toast.makeText(getActivity(), stringArray[position]+position+id, Toast.LENGTH_SHORT).show();
                    Boolean conn = check.checkNow(v.getContext());
                    if(conn == true){

                        Intent intent = new Intent(view.getContext(), Blogs.class);
                        intent.putExtra("pos", position);
                        startActivity(intent);
                    }

                    else {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                        builder1.setMessage("No internet connection available.");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                       //view.getContext().finish();
                                        getActivity().getFragmentManager().popBackStack();
                                    }
                                });


                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                }
            });







            /*prepareListBlogs();
            listAdapter = new ExpandableListAdapterN(getContext(), listDataHeader, listDataChild);
// setting list adapter
            expListView.setAdapter(listAdapter);
            heading.setBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            //cardView2.setCardBackgroundColor(getResources().getColor(R.color.black_ntransparent));
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
// Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    Toast.makeText(getActivity(),
                            listDataHeader.get(groupPosition) + " Collapsed",
                            Toast.LENGTH_SHORT).show();

                }
            });
            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    Intent intent = new Intent(getActivity(), Content.class);
                    intent.putExtra("pos", mPosition);
                    intent.putExtra("group", groupPosition);
                    intent.putExtra("child", childPosition);
                    startActivity(intent);
                    Log.d("childPosition", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + childPosition + groupPosition);
                    // TODO Auto-generated method stub
                    Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                            .show();
                    return false;
                }
            });*/
        }

        return v;
    }




//    @Override
//    public void onResume() {
//        super.onResume();
//        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
//                .MyClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
//                Log.i(LOG_TAG, " Clicked on Item " + position);
//            }
//        });
//    }

    public ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 5; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index ) ;
            results.add(index, obj);
        }
        return results;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void adjustScroll(int scrollHeight, int headerTranslationY)
    {
        mScrollView.setScrollY(headerTranslationY - scrollHeight);
    }

    @Override
    public void onScrollChanged(ScrollView view, int l, int t, int oldl, int oldt)
    {
        if (mScrollTabHolder != null)
            mScrollTabHolder.onScroll(view, l, t, oldl, oldt, mPosition);

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        // listDataHeader.add("TEAM 3E");
        // listDataHeader.add("HOBBY PROJECTS");
        for (int i = 0; i < companyHeader.length; i++) {
            listDataHeader.add(companyHeader[i]);
        }

        List<String> team3e=new ArrayList<String>();
        for (int i = 0; i <companyTeam3e .length; i++) {
            team3e.add(companyTeam3e[i]);
        }

        List<String> hobby=new ArrayList<String>();
        for (int i = 0; i <companyHobbyProjects .length; i++) {
            hobby.add(companyHobbyProjects[i]);
        }

        listDataChild.put(listDataHeader.get(0),team3e);
        listDataChild.put(listDataHeader.get(1),hobby);

    }


    private void prepareListSolutions() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("LMS DEVELOPMENT SOLUTIONS");
        listDataHeader.add("ELEARNING ECOMMERCE INTEGRATION");
        listDataHeader.add("MOBILE COMMERCE");
        listDataHeader.add("MOBILE LEARNING");
        listDataHeader.add("PLATFORMS");

        List<String> lms=new ArrayList<>();
        lms.add("LMS DEVELOPMENT SOLUTIONS");


        // Adding child data
        List<String> integration= new ArrayList<String>();
        integration.add("MAGENTO MOODLE INTEGRATION");
        integration.add("WOOCOMMERCE MOODLE INTEGRATION");

        List<String> commerce=new ArrayList<String>();
        commerce.add("MOBILE COMMERCE");

        // Adding child data
        List<String> mlearning= new ArrayList<String>();
        mlearning.add("MOODLE MOBILE APP");

        List<String> platforms= new ArrayList<String>();
        platforms.add("MAGENTO");
        platforms.add("MOODLE");


        listDataChild.put(listDataHeader.get(0),lms);
        listDataChild.put(listDataHeader.get(1), integration);
        listDataChild.put(listDataHeader.get(2),commerce);
        listDataChild.put(listDataHeader.get(3), mlearning);
        listDataChild.put(listDataHeader.get(4), platforms);
    }
    private void prepareListServices(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("ECOMMERCE SERVICES");
        listDataHeader.add("LMS SERVICES");

        // Adding child data
        List<String> ecommerce= new ArrayList<String>();
        ecommerce.add("ECOMMERCE ASSESSMENT");
        ecommerce.add("CUSTOM ECOMMERCE IMPLEMENATATION");
        ecommerce.add("ECOMMERCE SITE SUPPORT");
        ecommerce.add("MAGENTO 2 MIGRATION SERVICES");

        // Adding child data
        List<String> lms= new ArrayList<String>();
        lms.add("LMS CONSULTING SERVICES");
        lms.add("CUSTOM LMS IMPLEMENTATION");
        lms.add("MOODLE SUPPORT SERVICES");
        lms.add("ENTERPRISE DEPLOYMENT AND MANAGEMENT");



        listDataChild.put(listDataHeader.get(0), ecommerce);
        listDataChild.put(listDataHeader.get(1), lms);
    }
    private void prepareListBlogs() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("AGILE PROCESS");
        listDataHeader.add("BUSINESS");
        listDataHeader.add("DESIGN");
        listDataHeader.add("ELEARNING");
        listDataHeader.add("ECOMMERCE");
        listDataHeader.add("TECH");

        List<String> agile=new ArrayList<>();
        agile.add("AGILE PROCESS");

        List<String> business=new ArrayList<>();
        business.add("BUSINESS");

        List<String> design=new ArrayList<>();
        design.add("DESIGN");

        List<String> elearning=new ArrayList<>();
        elearning.add("ELEANING");

        List<String> ecommerce=new ArrayList<>();
        ecommerce.add("ECOMMERCE");

        List<String> tech=new ArrayList<>();
        tech.add("TECH");

        listDataChild.put(listDataHeader.get(0), agile);
        listDataChild.put(listDataHeader.get(1), business);
        listDataChild.put(listDataHeader.get(2), design);
        listDataChild.put(listDataHeader.get(3), elearning);
        listDataChild.put(listDataHeader.get(4),ecommerce);
        listDataChild.put(listDataHeader.get(5),tech);
    }
    private void prepareListDemos()
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("ECOMMERCE DEMOS");
        listDataHeader.add("ELEARNING DEMOS");
        listDataHeader.add("ECCOMMERCE ELEARNING INTEGRATION");


        List<String> EcommerceDemos=new ArrayList<>();
        EcommerceDemos.add("JEWELSKART");
        EcommerceDemos.add("MULTIKART");
        EcommerceDemos.add("BOOKSKART");
        EcommerceDemos.add("DIGITALKART");
        EcommerceDemos.add("WOOKART");


        List<String> ElearningDemos=new ArrayList<>();
        ElearningDemos.add("ECOURSES");
        ElearningDemos.add("SHAREDLMS");
        ElearningDemos.add("SCHOOLLMS");

        List<String> EEI=new ArrayList<>();
        EEI.add("EDUKART");
        EEI.add("WOOKARTLMS");



        listDataChild.put(listDataHeader.get(0), EcommerceDemos);
        listDataChild.put(listDataHeader.get(1),ElearningDemos);
        listDataChild.put(listDataHeader.get(2),EEI);

    }
    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {

                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, "View More", true);
                    }

                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }
}
