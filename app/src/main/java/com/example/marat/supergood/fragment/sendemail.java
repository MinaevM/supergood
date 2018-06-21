package com.example.marat.supergood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.marat.supergood.R;
/**
 * Created by HP on 5/7/2016.
 */
public class sendemail extends Fragment {

    Button sendEmailButton;
    EditText emailAddress;
    EditText emailSubject;
    EditText message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View q =  inflater.inflate(R.layout.send_email, container, false);

        emailAddress = (EditText) q.findViewById(R.id.email);
        emailSubject = (EditText) q.findViewById(R.id.subject);
        message = (EditText) q.findViewById(R.id.message);
        sendEmailButton = (Button) q.findViewById(R.id.send_button);

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toemailAddress = emailAddress.getText().toString();
                String msubject = emailSubject.getText().toString();
                String mmessage = message.getText().toString();

                Intent emailApp = new Intent(Intent.ACTION_SEND);
                emailApp.putExtra(Intent.EXTRA_EMAIL, new String[]{toemailAddress});
                emailApp.putExtra(Intent.EXTRA_SUBJECT, msubject);
                emailApp.putExtra(Intent.EXTRA_TEXT, mmessage);
                emailApp.setType("message/rfc822");
                startActivity(Intent.createChooser(emailApp, "Send Email Via"));

            }

        });
        return q;

    }

}