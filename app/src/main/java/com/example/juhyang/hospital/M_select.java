package com.example.juhyang.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class M_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_select);

        ImageView b = (ImageView) findViewById(R.id.newadd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        BacodeScan.class); // 다음 넘어갈 클래스 지정
                change.putExtra("istype","new");
                startActivity(change);
            }
        });

        ImageView c = (ImageView) findViewById(R.id.alreadyadd);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        BacodeScan.class); // 다음 넘어갈 클래스 지정
                change.putExtra("istype","already");
                startActivity(change);
            }
        });
    }



}
