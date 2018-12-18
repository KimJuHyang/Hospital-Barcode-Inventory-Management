package com.example.juhyang.hospital;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class M_Purchase extends Activity {

    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_code, edit_name, edit_attr, edit_cnt, edit_made, edit_maneger, edit_phone, edit_usedate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m__purchase);

        Intent intent = getIntent();//인텐트  받아오고
        String code = intent.getStringExtra("code");
        // Toast.makeText(this, code, Toast.LENGTH_LONG).show();

        final EditText codeset = (EditText) findViewById(R.id.getbacode);
        codeset.setText(code); //바코드 표시

        helper = new dbHelper(this);
        try {
            db = helper.getWritableDatabase();
            //데이터베이스 객체를 얻기 위하여 getWritableDatabse()를 호출

        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }

        edit_code = (EditText) findViewById(R.id.getbacode);
        edit_name = (EditText) findViewById(R.id.name);
        edit_attr = (EditText) findViewById(R.id.attr);
        edit_cnt = (EditText) findViewById(R.id.cnt);
        edit_made= (EditText) findViewById(R.id.made);
        edit_maneger= (EditText) findViewById(R.id.maneger);
        edit_phone = (EditText) findViewById(R.id.phone);
        edit_usedate = (EditText) findViewById(R.id.usedate);


        //버튼에 대한 클릭 처리기를 작성.

        //추가 버튼.
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String code = edit_code.getText().toString();
                String name = edit_name.getText().toString();
                String attr = edit_attr.getText().toString();
                String cnt = edit_cnt.getText().toString();
                String made = edit_made.getText().toString();
                String maneger = edit_maneger.getText().toString();
                String phone = edit_phone.getText().toString();
                String usedate = edit_usedate.getText().toString();

                db.execSQL("INSERT INTO contact VALUES(null, '"+code+"','"+name+"','"+attr+"'," +
                        "'"+cnt+"','"+made+"','"+maneger+"','"+phone+"','"+usedate+"');");

                Toast.makeText(M_Purchase.this, "등록완료", Toast.LENGTH_SHORT).show();

            }


        });



    }




}
