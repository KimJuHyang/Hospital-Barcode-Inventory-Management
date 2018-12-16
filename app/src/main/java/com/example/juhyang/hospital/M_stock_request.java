package com.example.juhyang.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

public class M_stock_request extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_stock_request);

        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.stock_map);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        M_stock_MAP.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });
    }



}
