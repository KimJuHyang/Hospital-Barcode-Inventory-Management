package com.example.juhyang.hospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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


        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.purchase);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        M_select.class); // 다음 넘어갈 클래스 지정
                        startActivity(change);
            }
        });

        //클릭시 다음화면 넘어가기
        ImageView a = (ImageView) findViewById(R.id.inventory_status);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change2 = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        M_InventoryStatus.class); // 다음 넘어갈 클래스 지정
                startActivity(change2);
            }
        });

        //클릭시 다음화면 넘어가기
        ImageView c = (ImageView) findViewById(R.id.stock_out);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change3 = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        M_StockOut.class); // 다음 넘어갈 클래스 지정
                startActivity(change3);
            }
        });


    }


}
