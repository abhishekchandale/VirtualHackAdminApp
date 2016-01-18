package com.example.abhishekchandale.virtualhackadminapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.abhishekchandale.virtualhackadminapp.R;
import com.example.abhishekchandale.virtualhackadminapp.emailer.GMailSender;

/**
 * Created by Abhishek.Chandale on 1/18/2016.
 */
public class ResponseMail extends AppCompatActivity {
    private ImageButton send_email;
    private EditText to,subject,body_message;
    private String toEmailer,subjectEmailer,bodyEmailer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_response_activity);
        send_email=(ImageButton)findViewById(R.id.email_send_action);
        to=(EditText)findViewById(R.id.ed_email_to);
        subject=(EditText)findViewById(R.id.ed_email_subject);
        body_message=(EditText)findViewById(R.id.ed_email_text);

        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    to.setText("developer.abhishek29@gmail.com");
                     subjectEmailer= subject.getText().toString();
                     bodyEmailer= body_message.getText().toString();
                     GMailSender sender=new GMailSender("developer.abhishek29@gmail.com","0101abhi");
                     sender.sendMail(subjectEmailer,bodyEmailer,"developer.abhishek29@gmail.com",toEmailer);


                }catch (Exception e){
                   Log.e("error_email",e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
