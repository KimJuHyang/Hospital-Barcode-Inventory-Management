package com.example.juhyang.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

public class P_Used extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__used);

        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.add_used);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        BacodeScan.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });

        ImageView a = (ImageView) findViewById(R.id.searchSick);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        P_sick_DB.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });
    }

}
