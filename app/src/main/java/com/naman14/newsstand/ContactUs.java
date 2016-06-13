package com.naman14.newsstand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roshu on 27/4/16.
 */
public class ContactUs extends AppCompatActivity implements View.OnClickListener{

    //Declaring EditText
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextMessage;

    //Send button
    private Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        editTextName = (EditText) findViewById(R.id.name);
        editTextEmail = (EditText) findViewById(R.id.mail);
        editTextPhone = (EditText) findViewById(R.id.phone);
        editTextMessage = (EditText) findViewById(R.id.body);
        buttonSend = (Button) findViewById(R.id.sendMailButton);

        int maxLength = 20;
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(maxLength);
        editTextName.setFilters(FilterArray);

        buttonSend.setOnClickListener(this);
    }

    private void sendEmail() {
        //Getting content for email
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

//        String recpEmail = "satishm@3esoftsol.com";
        String subject = "3E Site Query From : "+name;
        String actMessage = "\r\n"+"Mail Id : "+email+"\r\n"+"Phone : "+phone+"\r\n\r\n"+"Query :"+"\r\n"+message;
        //Creating SendMail object
        SendMail sm = new SendMail(this, Config.RECEIVEREMAIL, subject, actMessage);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        if(validateName() && validateEmail() && validateMessage()) {

            if(editTextPhone.getText().toString().length() == 0) {
                sendEmail();
            }else{
                if(editTextPhone.getText().toString().length() != 10){
                    editTextPhone.setError("Enter valid phone.");
                }else {
                    sendEmail();
                }
            }
        }
    }

    private boolean validateName(){

        String name = editTextName.getText().toString();

        if(name.length()==0 || validateFirstLetter(name)){
            //Toast.makeText(getApplicationContext(),"Please enter your name.",Toast.LENGTH_SHORT).show();
            editTextName.setError("Enter valid name!");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean validateEmail(){
        String email = editTextEmail.getText().toString();

        if(email.length() == 0 || validateFirstLetter(email) || !validateEmailFormat(email)){
            //Toast.makeText(getApplicationContext(),"Please enter your email.",Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Enter valid email");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean validateFirstLetter(String str){
        //{" ","`","~","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","{","]","}","|",";",":","'",",","<",".",">","/","?"};
        String s = " ~!@#$%^&*()_+`1234567890-=[]{}|;':,./<>?";
        for(int i=0; i < s.length(); i++){
            if(str.charAt(0) == s.charAt(i)){
                return true;
            }
        }
        return false;
    }

    private boolean validateMessage(){
        String msg = editTextMessage.getText().toString();
        if(msg.length() != 0){
            return true;
        }
        else{
            editTextMessage.setError("Enter your query.");
            return false;
        }
    }

    private boolean validateEmailFormat(String email){

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
