package com.example.juhyang.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ManagerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        final TextView myname = (TextView)findViewById(R.id.nameText);
        myname.setText(name); // 이름 표시
    }
}
