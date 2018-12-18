package com.example.juhyang.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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

        //클릭시 다음화면 넘어가기
        ImageView a = (ImageView) findViewById(R.id.used);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        P_Used.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });

        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.request);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        P_Request.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });

        //클릭시 다음화면 넘어가기
        ImageView c = (ImageView) findViewById(R.id.mylist);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                       P_my_request_list.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });
    }
}
