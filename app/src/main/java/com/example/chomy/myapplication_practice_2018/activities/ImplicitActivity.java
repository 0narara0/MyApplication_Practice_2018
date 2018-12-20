package com.example.chomy.myapplication_practice_2018.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chomy.myapplication_practice_2018.R;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPhoneEditTExt;
    private EditText mUrlEditTExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

      mPhoneEditTExt = (EditText) findViewById(R.id.phone_edit);
      mUrlEditTExt = (EditText) findViewById(R.id.url_edit);

      findViewById(R.id.phone_button).setOnClickListener(this);
      findViewById(R.id.url_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone_button:
                String phoneNumber = mPhoneEditTExt.getText().toString();
                dialPhone(phoneNumber);
                break;
            case R.id.url_button:
                String url = mUrlEditTExt.getText().toString();
                showUrl(url);
                break;
        }
    }

    private void showUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        //아래 코드는 인터넷 연결이 안되는데 이유를 모르겠음
//        if (url.startsWith("http://")){
//            url = "http://" + url;
//        }
//        Uri webpage = Uri.parse("http://"+ url);
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    private void dialPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "수행할 앱이 없어요", Toast.LENGTH_SHORT).show();
        }
    }
}
