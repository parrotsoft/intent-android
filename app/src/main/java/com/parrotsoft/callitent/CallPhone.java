package com.parrotsoft.callitent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallPhone extends AppCompatActivity implements View.OnClickListener {

    public Button btnCall;
    public EditText edNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        this.btnCall = findViewById(R.id.btnCall);
        this.edNumber = findViewById(R.id.edNumber);
        this.btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCall) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+this.edNumber.getText()+""));
            startActivities(new Intent[]{intent});
        }
    }
}