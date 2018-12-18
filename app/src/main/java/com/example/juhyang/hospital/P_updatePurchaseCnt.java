package com.example.juhyang.hospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class P_updatePurchaseCnt extends AppCompatActivity {

    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_code, edit_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_update_purchase_cnt);

        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.yes);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        P_Used.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });


        //클릭시 다음화면 넘어가기
        ImageView a = (ImageView) findViewById(R.id.no);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        PrimaryMenu.class); // 다음 넘어갈 클래스 지정
                startActivity(change);
            }
        });




    }
}
