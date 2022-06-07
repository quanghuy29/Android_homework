package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<MailModel> mails = MailData.getMailData();

        ListView listView = findViewById(R.id.listGmail);
        GmailAdapter adapter = new GmailAdapter(this, mails);
        listView.setAdapter(adapter);
    }
}