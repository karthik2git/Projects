package com.eeesoft.eeeapp;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Policy extends Activity {
TextView policy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        policy=(TextView)findViewById(R.id.txtPolicy);
         policy.setMovementMethod(new ScrollingMovementMethod());
        policy.setText("This Privacy Policy governs the manner in which 3E Software Solutions Pvt. Ltd. collects, uses, maintains and discloses information collected from users (each, a “User”) on its apps. This privacy policy applies to the website, app and all products and services in general offered by 3E Software Solutions Pvt. Ltd.\n" +
                "\n" +
                "Personal identification information\n" +
                "\n" +
                "We may collect personal identification information from users in a variety of ways in connection with activities, services, features or resources we make available on our app. Users may be asked for, as appropriate, name, email address, phone number etc. We will collect personal identification information from users only if they voluntarily submit such information to us. Users can always refuse to supply personally identification information, except that it may prevent them from engaging in certain app related activities.\n" +
                "\n" +
                "Non-personal identification information\n" +
                "\n" +
                "We may collect non-personal identification information about users whenever they interact with our app. Non-personal identification information may include the device name, the type of device and technical information about users means of connection, such as the operating system and the Internet service providers utilized and other similar information.\n" +
                "\n" +
                "How we use collected information\n" +
                "\n" +
                "3E Software Solutions Pvt. Ltd may collect and use users’ personal information for the following purposes:\n" +
                "\n" +
                "– To improve customer service: Information users provide helps us respond to customer service requests and support needs more efficiently.\n" +
                "\n" +
                "– To send periodic emails: If users decide to opt-in to our mailing list, they will receive emails that may include company news, updates, related product or service information, etc. If at any time the user would like to unsubscribe from receiving future emails, we include detailed unsubscribe instructions at the bottom of each email.\n" +
                "\n" +
                "How we protect your information\n" +
                "\n" +
                "We adopt appropriate data collection, storage and processing practices and security measures to protect against unauthorized access, alteration, disclosure or destruction of your personal information, username, password, transaction information and data stored on our servers.\n" +
                "\n" +
                "Sharing your personal information\n" +
                "\n" +
                "We do not sell, trade, or rent users’ personal identification information to others. We may share generic aggregated demographic information not linked to any personal identification information regarding visitors and users with our business partners, trusted affiliates and advertisers for the purposes outlined above.\n" +
                "\n" +
                "Third party websites\n" +
                "\n" +
                "Users may find advertising or other content on our app that link to the sites and services of our partners, suppliers, advertisers, sponsors, licencors and other third parties. We do not control the content or links that appear on these sites and are not responsible for the practices employed by websites or apps linked to or from our app. In addition, these sites or services, including their content and links, may be constantly changing. These sites and services may have their own privacy policies and customer service policies. Browsing and interaction on any other website or app, including websites/apps which have a link to our app, is subject to that website/app’s own terms and policies.\n" +
                "\n" +
                "Changes to this privacy policy\n" +
                "\n" +
                "3E Software Solutions Pvt. Ltd has the discretion to update this privacy policy at any time. We encourage users to frequently check this page for any changes to stay informed about how we are helping to protect the personal information we collect. You acknowledge and agree that it is your responsibility to review this privacy policy periodically and become aware of modifications.\n" +
                "\n" +
                "Your acceptance of these terms\n" +
                "\n" +
                "By using the app, users signify the acceptance of this policy. If users do not agree with this policy, they are requested not to use the app. The continued use of the app following the posting of changes to this policy will be deemed users’ acceptance of those changes.");
    }

}
