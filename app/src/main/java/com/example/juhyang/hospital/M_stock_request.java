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

    }



}
