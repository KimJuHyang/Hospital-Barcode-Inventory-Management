package com.example.juhyang.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class M_Purchase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m__purchase);

        ImageView b = (ImageView) findViewById(R.id.next);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        M_Purchase2.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });

        Intent intent = getIntent();//인텐트  받아오고
        String msg = intent.getStringExtra("data");

//        final TextView bacode = (TextView)findViewById(R.id.bacode);
//        bacode.setText(msg); // 이름 표시

    }




}
