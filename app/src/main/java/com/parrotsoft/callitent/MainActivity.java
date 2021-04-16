package com.parrotsoft.callitent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnOpenWeb, btnCallPhone, btnGoogleMap, btnTakenPicture, btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnOpenWeb = findViewById(R.id.btnOpenWeb);
        this.btnOpenWeb.setOnClickListener(this);

        this.btnCallPhone = findViewById(R.id.btnCallPhone);
        this.btnCallPhone.setOnClickListener(this);

        this.btnGoogleMap = findViewById(R.id.btnGoogleMap);
        this.btnGoogleMap.setOnClickListener(this);

        this.btnTakenPicture = findViewById(R.id.btnTakenPicture);
        this.btnTakenPicture.setOnClickListener(this);

        this.btnSendEmail = findViewById(R.id.btnSendEmail);
        this.btnSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnOpenWeb:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://miguellopezariza.com"));
                startActivities(new Intent[]{intent});
                break;
            case R.id.btnCallPhone:
                intent = new Intent(this, CallPhone.class);
                startActivities(new Intent[]{intent});
                // intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 3015575931"));
                // startActivities(new Intent[]{intent});
                break;
            case R.id.btnGoogleMap:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.957506109910017, -74.8488981069837"));
                startActivities(new Intent[]{intent});
                break;
            case R.id.btnTakenPicture:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivities(new Intent[]{intent});
                break;
            case R.id.btnSendEmail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hola");
                intent.putExtra(Intent.EXTRA_TEXT, "Hola Miguel Lopez Ariza, como estas ?");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"email"});
                startActivities(new Intent[]{intent});
                break;
        }
    }
}