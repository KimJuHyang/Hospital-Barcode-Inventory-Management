package com.example.juhyang.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


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
                        M_Purchase2.class);
                startActivity(change);
            }
        });


        Intent intent = getIntent();//인텐트  받아오고
        String code = intent.getStringExtra("code");
       // Toast.makeText(this, code, Toast.LENGTH_LONG).show();

        final TextView codeset = (TextView)findViewById(R.id.getbacode);
        codeset.setText(code); //어느 부서인지 표시해주기.

    }




}
