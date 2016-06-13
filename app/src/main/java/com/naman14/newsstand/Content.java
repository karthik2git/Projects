package com.naman14.newsstand;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Content extends Activity {
    TextView txt, heading;
    int position, parentpos, cpos,color;
    Intent intent;
    String header;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
       // txt = (TextView) findViewById(R.id.textView3);
        heading = (TextView) findViewById(R.id.heading);
        recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);
        intent = getIntent();
        position = intent.getIntExtra("pos", 0);//tab
        cpos = intent.getIntExtra("child", 0);//child
        parentpos = intent.getIntExtra("group", 0);//parent
        header=intent.getStringExtra("heading");
        color=intent.getIntExtra("color",0);
        Log.d("parent","pos"+parentpos);

        if (position == 1) {
             if(parentpos==0 && cpos==0)
             {
               Intent intent=new Intent(this,Team3EActivity.class);
                 startActivity(intent);
                 onBackPressed();
             }
            if(parentpos==1 && cpos==0)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_cookbotrecipes();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);

                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
               // heading.setText("COOKBOT RECIPES");
                //txt.setText("CookBot Recipes is a quick and easy to use app that helps you search for recipes to cook with the ingredients you have.");

        }
        if (position == 2) {
            if(parentpos==0)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_with_data();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                 recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
             //   heading.setText("LMS DEVELOPMENT");
              //  txt.setText("3E Software Solutions offers a complete range of LMS Development Solutions for Education and Workspace learning.We are commited to provide a variety of tools and solutions");
            }
            if (parentpos == 1 && cpos == 0) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_mmintegration();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("MAGENTO MOODLE INTEGRATION");
               // txt.setText("Magento Moodle integration offers best of the both worlds for someone who requires an ecommerce or elearning system with an addition requirement from other platform");
            }
            if (parentpos == 1 && cpos == 1) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_wocommerce();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
              //  heading.setText("WOOCOMMERCE MOODLE INTEGRATION");
               // txt.setText("For sonme time now,Moodle has been the world's most popular learning management system.WooCommerce Moodle integration is always an advantage since it provides a much stronger platform");
            }
            if(parentpos==2)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_mobilecommerce();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
              //  heading.setText("MOBILE COMMERCE");
               // txt.setText("With the continuously growing use of Mobile Devices for online transactions and online commerce,our Mobile Commerce solutions help our Clients deliver their eCommerce solutions to their customers on Mobile platform.");
            }
            if (parentpos == 3 && cpos == 0) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_moodlemobileapp();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("MOODLE MOBILE APP");
                //txt.setText("3E Software Solutions offers a customised Moodle Mobile App with a vast array of features");
            }
            if (parentpos == 4 && cpos == 0) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_magento();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("MAGENTO");
                //txt.setText("Magento is the world's most popular Open Source eCommerce softwre,owned by eBay Inc.Availablite in Community and Enterprise Editions,Magento is primarily developed in Linux Apache,MySQL and PHP.");
            }
            if (parentpos == 4 && cpos == 1) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_moodle();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                //heading.setText("MOODLE");
                //txt.setText("Moodle is World's most popular Open Source Learning Management System(LMS).Moodle allows users to create and administer interactive online courses.");
            }

        }
        if (position == 3) {
            if(parentpos==0 && cpos ==0)
            {
                //heading.setText("ECOMMERCE ASSESSMENT");
                //txt.setText("We provide pre-implementation LMS consulting services to our Clients");
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_ecommerce_assessment();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
            if(parentpos==0 && cpos==1)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_custom_ecommerce_implementation();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("CUSTOM ECOMMERCE IMPLEMENTATION");
               // txt.setText("Our philosophy is that every customer is diffrent,and every project requirement has its own unique attributes,its own past,present and future.This philosophy is integrated in every service we offer,be it eCommerce Assessment,eCommerce Assignment,eCommerce design and implementation and or eCommerce support");
            }
            if(parentpos==0 && cpos==2)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_ecommerce_sitesupport();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("ECOMMERCE SITE SUPPORT");
               // txt.setText("We provide post-implementation eCommerce consulting services to our clients.");
            }
            if(parentpos==0 && cpos==3)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_magento2();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //    heading.setText("MAGENTO 2 MIGRATION SERVICES");
              //  txt.setText("Magento provides a Magento 2 Migration tool that would help users to migrate product data,orders etc.It would also help with migration of CMS pages,store configarations,customer passwords etc.");
            }
            if (parentpos == 1 && cpos == 0) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_lmsconsulting();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("LMS CONSULTING SERVICES");
               // txt.setText("3E Software Solutions provides expert LMS consulting services and advisory on assessment of your LMS requirements.");
            }
            if(parentpos==1 && cpos ==1)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_customlmsimplementation();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("CUSTOM LMS IMPLEMENTATION");
               // txt.setText("Our philosophy is that every customer is diffrent ,and every project requirement has its own unique attributes,it's own past present and future.");
            }

            if(parentpos==1 && cpos ==2)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_moodlesupportservices();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
               // heading.setText("MOODLE SUPPORT SERVICES");
                //txt.setText("We provide post-implementation LMS Support Services to our clients.We provide Moodle Support services to make sure that your Moodle site is up to date with all security Updates,is optimised for Performance and stay current with all the latest updates.");
            }
            if(parentpos==1 && cpos ==3)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_enterprisedeployment();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("ENTERPRISE DEPLOYMENT AND MANAGEMENT");
                //txt.setText("We provide holistic solutions for enterprise customers by enabling them with high avilablity and performance optimmised deployment and management for LMS delivery");
            }


        }

        if (position == 4) {
            if(parentpos==0 && cpos ==0)
            {
                //heading.setText("ECOMMERCE ASSESSMENT");
                //txt.setText("We provide pre-implementation LMS consulting services to our Clients");
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_jewelskart();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
            if(parentpos==0 && cpos==1)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_multikart();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // heading.setText("CUSTOM ECOMMERCE IMPLEMENTATION");
                // txt.setText("Our philosophy is that every customer is diffrent,and every project requirement has its own unique attributes,its own past,present and future.This philosophy is integrated in every service we offer,be it eCommerce Assessment,eCommerce Assignment,eCommerce design and implementation and or eCommerce support");
            }
            if(parentpos==0 && cpos==2)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_bookskart();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // heading.setText("ECOMMERCE SITE SUPPORT");
                // txt.setText("We provide post-implementation eCommerce consulting services to our clients.");
            }
            if(parentpos==0 && cpos==3)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_digitalkart();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //    heading.setText("MAGENTO 2 MIGRATION SERVICES");
                //  txt.setText("Magento provides a Magento 2 Migration tool that would help users to migrate product data,orders etc.It would also help with migration of CMS pages,store configarations,customer passwords etc.");
            }
            if (parentpos == 0 && cpos == 4) {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_wookart();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // heading.setText("LMS CONSULTING SERVICES");
                // txt.setText("3E Software Solutions provides expert LMS consulting services and advisory on assessment of your LMS requirements.");
            }
            if(parentpos==1 && cpos ==0)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_ecourses();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // heading.setText("CUSTOM LMS IMPLEMENTATION");
                // txt.setText("Our philosophy is that every customer is diffrent ,and every project requirement has its own unique attributes,it's own past present and future.");
            }

            if(parentpos==1 && cpos ==1)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_sharedlms();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // heading.setText("MOODLE SUPPORT SERVICES");
                //txt.setText("We provide post-implementation LMS Support Services to our clients.We provide Moodle Support services to make sure that your Moodle site is up to date with all security Updates,is optimised for Performance and stay current with all the latest updates.");
            }
            if(parentpos==1 && cpos ==2)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = fill_schoollms();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("ENTERPRISE DEPLOYMENT AND MANAGEMENT");
                //txt.setText("We provide holistic solutions for enterprise customers by enabling them with high avilablity and performance optimmised deployment and management for LMS delivery");
            }
            if(parentpos==2 && cpos ==0)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = edukart_lms();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("ENTERPRISE DEPLOYMENT AND MANAGEMENT");
                //txt.setText("We provide holistic solutions for enterprise customers by enabling them with high avilablity and performance optimmised deployment and management for LMS delivery");
            }
            if(parentpos==2 && cpos ==1)
            {
                heading.setText(header);
                heading.setBackgroundColor(color);
                List<Data> data = wookart_lms();
                RecyclerAdapter adapter=new RecyclerAdapter(data,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //heading.setText("ENTERPRISE DEPLOYMENT AND MANAGEMENT");
                //txt.setText("We provide holistic solutions for enterprise customers by enabling them with high avilablity and performance optimmised deployment and management for LMS delivery");
            }
        }
    }
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();
        data.add(new Data("LMS DEVELOPMENT SOLUTIONS", "3E Software Solutions offers a complete range of LMS Development Solutions for Education and Work space learning. We are committed to provide wide variety of tools and services to match the diversified needs of users of such systems. With a broad focus on Open Source technologies and Open Standards, our Solutions and Services are customizable to Client specific requirements. We also offer Course-ware and Training through our Partnerships.\n" +
                "\n" +
                "Our expertise is in Moodle Development, Deployment, Integration and Support, with an emphasis on Scalable, Complete and High-Available solutions.\n" +
                "\n" +
                "Our LMS Offerings\n" +
                "\n" +
                "Solutions conforming to SCORM, TinCan and LIS\n" +
                "We offer expertise on Open Source LMS platforms and integrating them with third-party applications for customized B2C and B2B solutions.\n" +
                "Design & Develop single-tenant and multi-tenant LMS systems for customized requirements.\n" +
                "Offer all custom implementations which include features such as Student Management, Portfolio Management, Course Management, Course Enrollment (including Automatic Enrollment), Assignments, Quizzes, Certifications, Social Media integration, Virtual Classrooms and Recorded Libraries, Reporting and Dashboards, Cloud integration (Google Drive, Amazon S3, ..) for Storage\n" +
                "Cater to Corporate LMS needs and supports features such as Program Management, Learning Objectives, Learning & Development and Learning Outcomes",R.drawable.eee_logo));
        data.add(new Data("Where does LMS fit in Corporate landscape?", "Enables learning effectively through individual learning plans which are closely tied to Employees’ Roles, Training needs and Learning Objectives.\n" +
                "Enable Simplified and Strengthened Compliance, Certification by Systematic Learning Plans and Programs of Learning\n" +
                "Enable alignment of Learning Objectives of Individual Teams and Employees with Business Objectives and helps track those objectives with systematic tools and methods\n" +
                "Help Self-Assessment for Employees, through Quizzes and Assignments\n" +
                "Help Management and Human Resource Departments make informed decisions on Human Resource Management, Appraisals, Promotions etc\n" +
                "Help Management Leverage a Consistent Training Plan across all geographical location by addressing the limitations of physical classroom training", R.drawable.eee_logo));
        data.add(new Data("Where does LMS fit in Education landscape?","Enables Effective Teaching and Learning\n" +
                "Enabled Video based Learning, Multimedia based Learning\n" +
                "Enables Community Learning through support for Engagement and Collaboration among Students, between Faculty and Students\n" +
                "Enables Distance Learning\n" +
                "Enables Flipped Classroom Training\n" +
                "Enables Blended Learning experience for both Faculty and Students by mix of both Classroom and Online training\n" +
                "Helps Professional Development of Students\n" +
                "Helps Faculty and Management assess the Progress of Students on their Assigned Coursed, in a Systematic way\n" +
                "Enables Assessment through online Exams, Quizzes and Assignments", R.drawable.eee_logo));
        return data;
    }
public List<Data> fill_mmintegration() {
    List<Data> data = new ArrayList<>();
    data.add(new Data("What is Magento?","Magento is an open source eCommerce platform with over 150,000 online stores running on it, including some of the leading brands like Ford and Samsung. With more than 500,000+ Magento downloads since it was launched in 2008, Magento has 26% share of the eCommerce market and is a leader for 4 consecutive years ",R.drawable.magentow));
    data.add(new Data("What is Moodle?","Moodle is an open-source software LMS platform used for blended learning, distance education, flipped classroom and other eLearning projects in schools, universities, workplaces etc. A recent survey notes the increasing market share of Moodle, to over 10% while competitors’ market share seems to be decreasing.",R.drawable.moodlew));
    data.add(new Data("Why is Magento Moodle Integration is required?","Magento Moodle integration offers “best of the both worlds” for someone who requires an eCommerce or an eLearning system with an addition requirement from the other platform. It offers huge advantages to the user as well as the seller community, to demonstrate – while Single Sign On (SSO), account sync option and option to choose between different classes for the same course on Magento helps the user, simple setup of Moodle courses in Magento, single Magento account to enrol multiple students, marketplace management options like adaptive Paypal payments, vendor reviews etc, offers immense advantages to the course developer.\n" +
            "\n" +
            "Magento–Moodle integration is a huge improvement over other methods that rely on selling the “access methods” rather than the courses themselves. For e.g., one popular solution for selling Moodle courses on Magento is to generate a fixed number of enrolment codes in Moodle and sell the enrolment codes as products in Magento. This method does not “integrate” Magento and Moodle that seamlessly.   ",R.drawable.magento_moodle_integration));
    data.add(new Data("Magento-Moodle Integration Features","Magento Moodle Integration has a vast array of features; some of the distinct ones include:\n" +
            "Unified control of student accounts from either Magento or Moodle.\n" +
            "Course start and end date validation (option to disable the product in Magento after a set no. of days after the course starts in Moodle).\n" +
            "Reporting on user enrolment to courses.\n" +
            "Multiple classes in the Moodle course can be separately sold under the same product in Magento.\n" +
            "Enrolment of users to Moodle is only dependant on completion of the order (either automatically using payment gateways or manually in case of external bank transfers).\n" +
            "Custom email notification to students regarding enrolment success etc.\n" +
            "Same Magento account can be used to enroll multiple students.\n" +
            "Compatibility with a Multivendor marketplace setup in Magento, where vendors can upload and maintain SCORM compatible courses and students in Moodle and sell them using the Shopping Cart system in Magento. This comes with additional marketplace management options including adaptive paypal payments, vendor reviews etc.\n" +
            "Simple setup for setting up Moodle courses in Magento (via live synced Moodle courses on the product upload page using a simple dropdown menu)\n" +
            "Single Sign On\n" +
            "\n" +
            "Users need to login only on Magento or Moodle and they will be automatically logged into the other.\n" +
            "Account changes (password changes, account deletion etc.) are synced from Magento to Moodle and vice versa automatically.",R.drawable.eee_logo));
    return  data;
}
    public List<Data> fill_wocommerce(){
        List<Data> data = new ArrayList<>();
        data.add(new Data("What is WooCommerce?","WooCommerce is an opensource plugin for WordPress that enables users to integrate eCommerce Shopping cart features with their WordPress website. WooCommerce is a very popular eCommerce solutions used by over 380,000 online retailers worldwide with a market share of 30% of all eCommerce sites. ",R.drawable.woocommerce));
        data.add(new Data("What is Moodle?","Moodle is an open-source software LMS platform used for blended learning, distance education, flipped classroom and other eLearning projects in schools, universities, workplaces etc. A recent survey notes the increasing market share of Moodle, to over 10% while competitors’ market share seems to be decreasing.",R.drawable.moodlew));
        data.add(new Data("Why is WooCommerce Moodle Integration required?","For some time now, Moodle has been the world’s most popular learning management system. WooCommerce Moodle integration is always an advantage since it provides a much stronger blogging platform. Also WordPress has better Search Engine Optimization ability than standalone Moodle. In addition, WooCommerce Moodle integration can enable an eCommerce Platform for monetization of courses. ",R.drawable.woocommerce_moodle_integration));
        return  data;
    }
    public List<Data> fill_mobilecommerce()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("MOBILE COMMERCE","With the continuously growing use of Mobile Devices for online transactions and online commerce, our Mobile Commerce solutions help our Clients deliver their eCommerce solutions to their customers (B2B or B2C) on Mobile Platform.\n" +
                "\n" +
                "Salient Features Of Mobile Commerce\n" +
                "\n" +
                "Swipe Feature – Swipe left/right on products and categories\n" +
                "Call Feature – Call Suport or the Vendor from directly within the app\n" +
                "GPS – Deliver Content based on precise user location\n" +
                "Push Notifications – Push notifications for New arrivals, App updates, order tracking, discounts, offers etc.\n" +
                "Interstilial Ads – Show New Products, Discounts, Deals etc. on app startup or during page transitions\n" +
                "One time Login – Login once after App install\n" +
                "Save products for wishlists\n" +
                "OS specific theme and UI/UX for Android/iOS etc.\n" +
                "Share through social media apps, Facebook Connect and Google + Connect",R.drawable.eee_logo));
        return data;
    }
public  List<Data> fill_moodlemobileapp()
{
    List<Data> data = new ArrayList<>();
    data.add(new Data("Why is a Moodle Mobile App required?","Moodle is the leading LMS platform and the go-to solution for most who want to start a Learning Management System. To put it simply, Moodle works for most people from those who run small systems for Home Schooling to Large University groups. Add to that the increasing penetration of Mobile devices into all aspects of businesses, it becomes imperative to take Moodle to Mobile devices. To facilitate learners who want to learn on their mobile devices on-the-go and to empower LMS providers who want to enable their learners to do so, we offer custom Moodle Mobile App solutions for Android and iOS devices. ",R.drawable.moodle_mobile_app));
    return  data;
}
    public List<Data> fill_magento()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("What is Magento?","Magento is the world’s most popular Open Source eCommerce software, owned by eBay Inc. Available in Community and Enterprise Editions, Magento is primarily developed in Linux using Apache, MySQL and PHP. Magento has ~25% market share which means 1 of every 4 eCommerce businesses chose Magento. $25 billion+ transaction volume each year.\n" +
                "\n" +
                "\n" +
                "Magento is the Leading Open Source eCommerce Software with over 70 million downloads. Magento Community Edition is FREE with No Licensing Fee, distributed under the Open Software License (OSL 3.0).\n" +
                "\n" +
                "Developers can modify the source code and add features and functionality by creating or installing add-ons and plug-ins as per your business requirement.Supports Multiple Stores and Multiple Vendors\n" +
                "\n" +
                "Supports Product Browsing, Shipping, Tracking etc. Flexible and Scalable to suit all business models and sizes, from small business to sophisticated eCommerce business needs. ",R.drawable.magento_open_source_ecommerce));
        data.add(new Data("Why Magento","Magento is the Leading Open Source eCommerce Software with over 70 million downloads\n" +
                "Magento Community Edition is FREE with No Licensing Fee, distributed under the Open Software License (OSL 3.0), and is thus open source software\n" +
                "Developers can modify the source code and add features and functionality by creating or installing add-ons and plug-ins as per your business requirement.\n" +
                "Supports Multiple Stores and Multiple Vendors implementation and thus provide a comprehensive eCommerce solutions\n" +
                "Supports multi-site implementation for multiple stores, and helps you manage them from Single Admin Panel\n" +
                "Supports multiple currencies, multiple languages, internationalization\n" +
                "Supports multiple currencies, multiple languages, internationalization\n" +
                "Supports Product Browsing, Shipping, Tracking etc\n" +
                "Flexible and Scalable to suit all business models and sizes, from small business to sophisticated eCommerce business needs\n" +
                "SEO built-in features such as clean URLs, tags and descriptions\n" +
                "Supports Bulk uploads\n" +
                "Wide variety of Product Search options\n" +
                "Integrated Google Analytics\n" +
                "No limits on number of products or purchases\n" +
                "Moodle Community Driven, FREE and PAID plugins are available for any eCommerce requirement, you name it. ",R.drawable.ecommerce));
         return  data;
    }
    public List<Data> fill_moodle()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("What is Moodle?","Moodle is World’s most popular Open Source Learning Management System (LMS). Moodle allows users to create and administer interactive online courses. The Moodle software is web-based and free for registration, easy use and customization, making it more scalable, flexible and affordable than other proprietary LMS solutions.\n" +
                "Moodle is an Excellent Learning Platform for both Educators and Corporate Learning & Development Professionals.  Moodle provides powerful learning platforms for Online Training. Moodle is primarily developed in Linux using Apache, MySQL and PHP\n" +
                "\n" +
                "Multilingual\n" +
                "\n" +
                "Multilingual\n" +
                "Open Source\n" +
                "Moodle is the Leading Open Source LMS Platforms with over 70 million download. Moodle is FREE with No Licensing Fee, available under GNU Generic Public License.\n" +
                "\n" +
                "Community\n" +
                "Moodle is not just a platform, it is a Community. Moodle Community Driven, Globally Supported. Moodle is a Robust LMS platform powering the eLearning\n" +
                "\n" +
                "Responsive Design\n" +
                "Moodle is built to the Open Standards, Interoperable by Design and thus enables integration with other Open Source and Proprietary Applicational information.",R.drawable.moodle_lms));
        data.add(new Data("WHY MOODLE?","Moodle is the Leading Open Source LMS Platforms with over 70 million downloads\n" +
                "Moodle is FREE with No Licensing Fee, available under GNU Generic Public License.\n" +
                "Moodle is not just a platform, it is a Community\n" +
                "Moodle Community Driven, Globally Supported\n" +
                "Moodle is a Robust LMS platform powering the eLearning environments worldwide\n" +
                "Moodle is a Content Management System (CMS) at the core of it, offering an Easy to Use interface for all of its users, be it a Student, Teacher or Administrator; Or, be it an Employee, Manager, Learning and Development Professional\n" +
                "Moodle is designed with Mobile-First philosophy and comes with Responsive Design, providing an interface which is easily accessible by on both Web and Mobile platforms\n" +
                "Moodle is primarily developed in Linux using Apache, MySQL and PHP.\n" +
                "Moodle is built to the Open Standards, Interoperable by Design and thus enables integration with other Open Source and Proprietary Applications and Information Systems to build end-to-end solutions. This allows institutions to build comprehensive solutions with seamless integration of both Workflow and Content.\n" +
                "Moodle is Learning Tools Interoperabiltiy (LTI) v2.0 Compliant, allowing Moodle users to integrate and present externally hosted applications and content on a Single Moodle Platform and avoid the registration, easy use and customization, making it more scalable, flexible and affordable than other proprietary LMS solutions.\n" +
                "Moodle is an Excellent Learning Platform for both Educators and Corporate Learning & Development Professionals\n" +
                "Moodle provides powerful learning platforms for Online Training. ",R.drawable.moodle));
        return  data;
    }
    public List<Data> fill_ecommerce_assessment()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("ECOMMERCE ASSESSMENT","We provide pre-implementation LMS consulting services to our Clients.\n" +
                "\n" +
                "We provide expert advisory and consulting services on assessment of your eCommerce platform requirements. We engage our eCommerce Development team, comprised of eXpert Magento and WooCommerce Developers, to work closely with our Clients to understand their Shortterm and Longterm objectives of their planned eCommerce Site implementation and help you make informed decisions ranging from ‘Which Platform is the Right Choice for you’ to ‘Assessing the Technical Implementation choices with that Platform. This helps individuals and organizations who are getting started with their eCommerce site implementations but are new to eCommerce software (or eCommerce itself) or in ‘still evaluating’ the technical choices against their requirements.\n" +
                "\n" +
                "Our Assessment services also serve the Clients who already have made a decision to build on the platform or have already built their eCommerce site. Our eCommerce Consulting Services help them understand all the options they have with respect to Design, Functionality, Hosting and Integration with other Applications (ERP, CRM, Multi-Channel Commerce, Cloud Storage, …), Content Management Systems (WordPress, Joomla, …), eLearning Platforms for selling Online Courses, and Payment Gateways. ",R.drawable.eee_logo));

        return  data;
    }
    public List<Data> fill_custom_ecommerce_implementation()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("CUSTOM ECOMMERCE IMPLEMENTATION","Our philosophy is that every customer is different, and every project requirement has its own unique attributes, its own past, present and future. This philosophy is integrated in every service we offer, be it eCommerce Assessment, eCommerce design and implementation or eCommerce Support.\n" +
                "\n" +
                "The Horizon Of Our ECommerce Services…\n" +
                "\n" +
                "Design and Development\n" +
                "Performance Optimization and High-Availability Deployment\n" +
                "Security Hardening\n" +
                "Payment Integration / eLearning eCommerce Integration\n" +
                "Theme Selection / Customized Theme Development\n" +
                "We Build ECommerce Solutions For …\n" +
                "\n" +
                "Single Store eTailer Business\n" +
                "Multiple Store eTailer Business\n" +
                "Online MarketPlace\n" +
                "We Build ECommerce Solutions To Enable Our Clients Sell …\n" +
                "\n" +
                "Physical Products\n" +
                "Digital Products\n" +
                "Virtual Products\n" +
                "Rentals\n" +
                "Services\n" +
                "And What Not?\n" +
                "We Build ECommerce Solutions By Following …\n" +
                "\n" +
                "Requirements Management\n" +
                "Agile Practices\n" +
                "Feature Prioritization and Iterative & Incremental Development\n" +
                "Early Customer Engagement ",R.drawable.eee_logo));
        return  data;
    }
    public List<Data> fill_ecommerce_sitesupport()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("ECOMMERCE SITE SUPPORT","We provide post-implementation eCommerce consulting services to our clients.\n" +
                "\n" +
                "We provide Technical Support services and enable your Magento or WooCommerce site is up to date with all Security Updates, is optimized for Performance, and stay current with all the latest Moodle updates, and as well ensure that the industry best practices are followed by your team.\n" +
                "\n" +
                "The eCommerce Support Services, provided on an Annual Retainer basis, provide technical support to eCommerce Site’s key personnel from Clients’ teams. The Support services include both Usability (Functional) and Administration services.\n" +
                "\n" +
                "LMS Usability Support:\n" +
                "\n" +
                "Best Practices\n" +
                "Tier-1 Support\n" +
                "Our team will share and guide you on the industry best practices and trends to maximize the benefits of the eCommerce software and leverage the platforms to its best potential to suit your custom requirements\n" +
                "\n" +
                "eCommerce Administrative Support:\n" +
                "\n" +
                "Installation of blocks, modules, update themes and other minor changes\n" +
                "Platform Upgrades\n" +
                "Health Monitoring, Logs Check (Smoke Detection), Server Status Monitoring\n" +
                "Security Patches Updates, Performance Patches Updates, Other Critical Updates (*It is very important to understand the need for every update and understand impact and make informed decision to go with that update or not) ",R.drawable.eee_logo));
        return  data;
    }
    public List<Data> fill_magento2()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("MAGENTO 2 DEMO WITH SAMPLE DATA","Our Magento 2 Demo comes with sample data and is ready to be tested. We have also provided administrator access so that users may play around and check the changes themselves before downloading the latest version. The latest Magento 2 release is a complete overhaul with a lot of feature additions and functional improvements. Feel free to check out Magento 2’s feature improvements listed below before accessing the Magento 2 Demo.\n" +
                "\n" +
                "Distinct Feature Improvements\n" +
                "\n" +
                "The following are the top-level feature improvements in Magento 2\n" +
                "\n" +
                "Improved Cache Management\n" +
                "\n" +
                "Database Refinements\n" +
                "\n" +
                "Better Page Speeds\n" +
                "\n" +
                "Code Base improvements\n" +
                "\n" +
                "Better User Experience\n" +
                "\n" +
                "Automated Testing Integration\n" +
                "\n",R.drawable.eee_logo));
        data.add(new Data("Full Feature List","The following is the full list of feature improvements in Magento 2\n" +
                "\n" +
                "Decoupled Back-end Store Logic\n" +
                "Full Page Caching\n" +
                "Varnish 4 Compatibility\n" +
                "HHVM 3.6 Compatibility\n" +
                "Proactive Caching\n" +
                "Browser Caching\n" +
                "25% Faster Page Speeds\n" +
                "Reduced JS Calls\n" +
                "Basic HTML page pre-render\n" +
                "Image Compression\n" +
                "JQuery bundling\n" +
                "RequireJS bundling\n" +
                "Responsiveness out-of-the-box\n" +
                "Streamlined Checkout\n" +
                "Removal of Guest/Login Checkout\n" +
                "Autofilled Checkout details\n" +
                "Modularized Search Interface\n" +
                "Improved UI Library\n" +
                "Optimized Indexer\n" +
                "Improved DB Query Speeds\n" +
                "Seperate Database for Orders\n" +
                "Support 10 Mil pageviews/hour\n" +
                "Simplified Upgrade Process\n" +
                "Easier Customizations\n" +
                "Improvised support for HTML5\n" +
                "Better CSS Pre-Processor\n" +
                "Improved Theme Management\n" +
                "Streamlined Layouts\n" +
                "Proactive XML Validation\n" +
                "Integrated Automated Testing\n" +
                "Magento Testing Framework\n" +
                "Automated Unit Testing\n" +
                "Automated Integration Testing\n" +
                "Automated Static Testing\n" +
                "Automated Legacy Testing\n" +
                "Automated Functional Testing\n" +
                "Automated Performance Testing\n" +
                "Automated Regression Testing\n" +
                "Automated Smoke Testing\n" +
                "Run all tests together ",R.drawable.eee_logo));
        data.add(new Data("Gallery","Magento is an opensource eCommerce platform with over 150000 online stores running on it,including some of leading brands like Ford and Samsung.With more than 500000+ Magento downloads since it was launched in 2008,Magento has 26% of share of the eCommerce market and is a leader for 4 consecutive years. ",R.drawable.eee_logo));
        return  data;
    }
    public List<Data> fill_lmsconsulting()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("LMS Consulting Services","3E Software Solutions provides expert LMS consulting services and advisory on assessment of your LMS requirements. We engage our eLearning Development team, comprised of expert Moodle Developers, to work closely with our Clients to understand their Short-term and Long-term objectives of their planned LMS implementation and help you make informed decisions ranging from ‘Is Moodle a right choice for your requirements’ to ‘Assessing the Technical Implementation choices with Moodle’. Our LMS Consulting Services help individuals and organizations who are getting started with their LMS implementations but are new to Moodle (or LMS) or in ‘still evaluating’ Moodle against their requirements.",R.drawable.eee_logo));
        data.add(new Data("Assessment services","Our Assessment services also serve the Clients who already have made a decision to build on Moodle platform or have already built their Moodle based LMS. Our Moodle Consulting Services help them understand all the options they have with respect to Design, Functionality, Hosting and Integration with other Applications (ERP, CRM, ePortfolio Management Systems, WebConferencing Tools, Cloud Storage, …), Content Management Systems (WordPress, Joomla, …), eCommerce Platforms (Magento, WooCommerce for Marketplace solutions) and Payment Gateways.",R.drawable.eee_logo));
        data.add(new Data("Custom LMS Implementation","Our philosophy is that every customer is different, and every project requirement has its own unique attributes, its own past, present and future. This philosophy is integrated in every service we offer, be it LMS Assessment, LMS design and implementation or LMS Support.\n" +
                "\n" +
                "The Horizon of our LMS services\n" +
                "\n" +
                "Design and Development\n" +
                "Performance Optimization and High-Availability Deployment\n" +
                "Security Hardening\n" +
                "Payment Integration / eLearning eCommerce Integration\n" +
                "Theme Selection / Customized Theme Development\n" +
                "We build LMS solutions with..\n" +
                "\n" +
                "Multimedia Interactivity\n" +
                "Virtual Classroom / Video Conferencing\n" +
                "Gamification\n" +
                "Live and Recorded Webinars\n" +
                "Integrated Badges\n" +
                "Some more solutions..\n" +
                "\n" +
                "Multi Tenancy\n" +
                "Social Learning through Social Media Integration\n" +
                "Personalized Learning\n" +
                "Adaptive Learning\n" +
                "Blended Learning\n" +
                "We build LMS solutions for..\n" +
                "\n" +
                "Higher Education\n" +
                "K12 Education\n" +
                "Corporate\n" +
                "Training Institutions\n" +
                "eLearning Marketplace Businesses\n" +
                "We build LMS solutions by following..\n" +
                "\n" +
                "Requirements Management\n" +
                "Agile Practices\n" +
                "Feature Prioritization and Iterative & Incremental Development\n" +
                "Early Customer Engagement",R.drawable.eee_logo));
                return data;
    }
    public List<Data> fill_customlmsimplementation()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("CUSTOM LMS IMPLEMENTATION","Our philosophy is that every customer is different, and every project requirement has its own unique attributes, its own past, present and future. This philosophy is integrated in every service we offer, be it LMS Assessment, LMS design and implementation or LMS Support. ",R.drawable.eee_logo));
        return data;
    }
    public List<Data> fill_moodlesupportservices()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("MOODLE SUPPORT SERVICES","We provide post-implementation LMS support services to our clients.\n" +
                "\n" +
                "We provide Moodle Support services to make sure that your Moodle site is up to date with all Security Updates, is optimized for Performance and stay current with all the latest updates. We ensure that the industry best practices are followed by your team.\n" +
                "\n" +
                "The Moodle Support Services, provided on an Annual Retainer basis, provide technical support to Site’s key personnel from Client’s team. The Support services include both Usability (Functional) and Administration services. ",R.drawable.lms_support_services));
        data.add(new Data("Our Range of Moodle Support Services (WHAT)","Theme Customization and Updates\n" +
                "Course Conversion Guide\n" +
                "Site Migrations\n" +
                "SSO (Single-Sign-On Integration)\n" +
                "Hosting Server Configuration\n" +
                "Plugin Setup & Configuration\n" +
                "Installation of Blocks, Modules\n" +
                "Platform Upgrades\n" +
                "Installation of Security Patches\n" +
                "Backups and Restorations\n" +
                "Installation of Performance Patches\n" +
                "Other Critical Updates\n" +
                "Best Practices and How-Tos\n" +
                "Tier-1 Support and Trouble Shooting\n" +
                "Role privileges management ",R.drawable.eee_logo));
        data.add(new Data("Delivery of Moodle Support Services (HOW)","FREE Moodle Support Services\n" +
                "\n" +
                "We offer FREE Moodle support which comes as a support package so that you can concentrate on your business and leave the trouble to us. The free support is valid for one month with a maximum of 20 hours of support.\n" +
                "\n" +
                "Course Conversion\n" +
                "Site Migrations\n" +
                "Plugin Setup & Configuration\n" +
                "Installation of Blocks, Modules, etc.\n" +
                "Installation of Security Patches\n" +
                "Installation of Performance Patches\n" +
                "Health Check-Up\n" +
                "Answering Questions\n" +
                "One time website Backup & Restoration\n" +
                "Changing role privileges\n" +
                "Other Critical Updates\n" +
                "Suggestion on Best Practices\n" +
                "*All the installation/changes will be done on the Moodle system meant for development. No changes will be made on the production/live Moodle system unless it is approved on development.\n" +
                "\n" +
                "*Administrative access should be given on both server as well as on the Moodle Dashboard. ",R.drawable.eee_logo));
        data.add(new Data("One Time Moodle Support Services","ontact us to tell us what you would like to accomplish.\n" +
                "We’ll confirm our understanding of your request and email you a quote.\n" +
                "Upon your approval, we’ll make the changes on our test server using a replica of your Moodle site.\n" +
                "You review the change(s) on our test Moodle site and provide your feedback and/or approval.\n" +
                "Once approved, you make payment and we install the solution on your live Moodle site.",R.drawable.eee_logo));
                return data;
    }
    public List<Data> fill_enterprisedeployment()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("ENTERPRISE DEPLOYMENT AND MANAGEMENT","We provide holistic solutions for enterprise customers by enabling them with high-availability and performance-optimized deployment and management for LMS delivery.\n" +
                "\n" +
                "Our deployment and management services cover..\n" +
                "\n" +
                "Integrations\n" +
                "\n" +
                "Moodle and Mahara integration\n" +
                "1.Mahoodle helps the users in which they can switch easily from LMS to E-PORTFOLIO or vice versa in single domain.\n" +
                "\n" +
                "2.Mahoodle also helps the users in which they can export the content from the moodle to mahara.\n" +
                "\n" +
                "3.If the users in moodle are students then they can only view the courses. but after the integration they can also showcase their achievements through mahara.\n" +
                "\n" +
                "4.If the users in mahara are some normal users. if they want to learn some courses they can easily switch to moodle.\n" +
                "\n" +
                "5.if the users are created on moodle platform then automatically the users will be created on mahara and they can easily roam into that site.\n" +
                "\n" +
                "Moodle and WordPress Integration\n" +
                "Integration plugin that allows you to import Moodle courses to WordPress by selecting ‘Synchronize Courses as Drafts’ following which courses in Moodle will be imported to WordPress.\n" +
                "sell Moodle courses from WordPress by importing course data from Moodle and using PayPal.\n" +
                "Users that register on WordPress to take or purchase a course get automatically registered on the Moodle learning management system.\n" +
                "The WordPress Moodle Integration provides end users with an option to login to both websites with the same credentials. Also, when the password is reset on WordPress it is updated on Moodle too.\n" +
                "Course categories can be created on the WordPress website. These categories can then be assigned to courses imported from Moodle using the WordPress Moodle Integration plugin.\n" +
                "Moodle Magento Integration\n" +
                "Single Sign On for Magento and Moodle\n" +
                "Account sync option which updates changes to user details on one system to the other in real time\n" +
                "Option to choose between different classes for the same course on Magento\n" +
                "Same Magento account can be used to enroll multiple students\n" +
                "Compatibility with a Multivendor marketplace setup in Magento, where vendors can upload and maintain SCORM compatible courses and students in Moodle and sell them using the Shopping Cart system in Magento. This comes with additional marketplace management options including adaptive Paypal payments, vendor reviews etc.\n" +
                "Simple setup for setting up Moodle courses in Magento (via live synced Moodle courses on the product upload page using a simple dropdown menu) ",R.drawable.eee_logo));
              return data;
    }
    public List<Data> fill_cookbotrecipes()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("COOKBOT RECIPES","CookBot Recipes is a quick and easy to use app that helps you search for recipes to cook with the ingredients you have. This cooking app offers an advanced “search by ingredients” feature that helps you find recipes from among hundreds of thousands of recipes from top sites. With CookBot, you don’t have to visit multiple websites to search for recipes; simply search by ingredients you have at home or by name of the recipe and get featured recipes listed within the app. Further, you also have the option to exclude ingredients which you are allergic to or dislike.",R.drawable.eee_logo));
        return data;

    }
    public List<Data> fill_jewelskart()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("JEWELSKART","<ul><li>India-based localization, taxes and logistics integration with table rate implementation</li><li>Bootstrap Responsive Theme</li><li>Live customer chat and analytics</li><li>Customer tracking based “Related Products”</li><li>Integrated product enquiry management</li><li>Twitter feed integration</li><li>Integration with Fedex Shipping Services</li></ul>",R.drawable.jewelskart));
        return data;
    }
  public List<Data>  fill_multikart()
  {
      List<Data> data = new ArrayList<>();
      data.add(new Data("MULTIKART","Multi-vendor marketplace\n" +
              "Adaptive Paypal payments for percentage-based real-time revenue sharing between Store Owner and Vendors\n" +
              "Self-customizable vendor profile\n" +
              "Vendor & product approval management\n" +
              "Vendor ratings and feedbacks\n" +
              "Social media connect for Store and Vendors",R.drawable.multikart));
      return data;
  }
    public List<Data>  fill_bookskart()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("BOOKSKART","Integration with Measured Search for advanced cloud based indexing, search and auto complete\n" +
                "Infinite scroll on product lists\n" +
                "Customer tracking based related products\n" +
                "Sidebar sorting\n" +
                "Unlimited downloaded size\n" +
                "Social Media share options product description page",R.drawable.bookskart));
        return data;
    }
    public List<Data>  fill_digitalkart()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("DIGITALKART","Download limits\n" +
                "Responsive theme\n" +
                "Download link encoding\n" +
                "Unlimited downloaded size\n" +
                "Home page carousels and product image zoom\n" +
                "Download link encoding",R.drawable.digitalkart));
        return data;
    }
    public List<Data>  fill_wookart()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("WOOKART","Woocommerce based Multi vendor store\n" +
                "Automatic currency conversion based on user location\n" +
                "Predictive search with thumbnails\n" +
                "Analytics based product recommendation\n" +
                "Product reviews and buyer follow-up",R.drawable.wookart));
        return data;
    }
    public List<Data>  fill_ecourses()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("ECOURSES","Personalised Dashboard\n" +
                "Collaborative tools and activities\n" +
                "All-in-one calendar\n" +
                "Secure authentication and mass enrolment\n" +
                "Bulk course creation and easy backup\n" +
                "Detailed reporting and logs",R.drawable.ecourses));
        return data;
    }
    public List<Data>  fill_sharedlms()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("SHAREDLMS","A single Moodle system shared between multiple Universities\n" +
                "Personalised Dashboard\n" +
                "Collaborative tools and activities\n" +
                "Bulk course creation and easy backup\n" +
                "Detailed reporting and logs",R.drawable.sharedlms));
        return data;
    }
    public List<Data>  fill_schoollms()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("SCHOOLLMS","Designed for K-12 schools\n" +
                "Site-level analytics\n" +
                "User engagement analytics\n" +
                "Bulk course creation and easy backup\n" +
                "Virtual classroom integration\n" +
                "Collaborative tools and activities",R.drawable.schoollms));
        return data;
    }
    public List<Data>  edukart_lms()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("EDUKARTLMS","Magento and Moodle integration\n" +
                "Single Sign On, account sync and course auto enrolment in Magento and Moodle systems\n" +
                "Create SCORM compatible courses in Moodle and use the shopping cart in Magento to sell\n" +
                "Date validation of Moodle courses in Magento\n" +
                "Gift Cards",R.drawable.edukart));
        return data;
    }
    public List<Data>  wookart_lms()
    {
        List<Data> data = new ArrayList<>();
        data.add(new Data("WOOKARTLMS","Integration of WooCommerce and Moodle\n" +
                "Single-Sign On and course auto enrollment\n" +
                "Payment gateways integration with Paypal, Pay U Money, CCAVENUE and PayTM\n" +
                "Auto course synchronization in Magento\n" +
                "User Analytics for both eCommerce and eLearning Systems.",R.drawable.wookartlms));
        return data;
    }
}