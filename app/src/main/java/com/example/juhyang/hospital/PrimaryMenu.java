package com.example.juhyang.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PrimaryMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_menu);

        Intent intent = getIntent();
        String data = intent.getStringExtra("value");
        String name = intent.getStringExtra("name");

        final TextView tv = (TextView)findViewById(R.id.departText);
        tv.setText(data); //어느 부서인지 표시해주기.

        final TextView myname = (TextView)findViewById(R.id.nameText);
        myname.setText(name); // 이름 표시
    }
}
