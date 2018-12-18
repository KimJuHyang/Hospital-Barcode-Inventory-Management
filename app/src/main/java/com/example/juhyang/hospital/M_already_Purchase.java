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

public class M_already_Purchase extends AppCompatActivity {

    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_code, edit_name, edit_attr, edit_cnt, edit_usedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_already__purchase);

        Intent intent = getIntent();//인텐트  받아오고
        String code = intent.getStringExtra("code");
        // Toast.makeText(this, code, Toast.LENGTH_LONG).show();

        final EditText codeset = (EditText) findViewById(R.id.getbacode);
        codeset.setText(code); //바코드 표시


        // DB search code
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
            edit_usedate = (EditText) findViewById(R.id.usedate);


            //버튼에 대한 클릭 처리기를 작성.

            //검색 버튼
            findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String code = edit_code.getText().toString();
                    Cursor cursor;
                    cursor = db.rawQuery("SELECT code, name, attr, cnt, usedate FROM contact where code='"+code+"';" , null);

                    while(cursor.moveToNext()){
                        String name = cursor.getString(1);
                        edit_name.setText(name);
                        String attr = cursor.getString(2);
                        edit_attr.setText(attr);
                        String cnt = cursor.getString(3);
                        edit_cnt.setText(cnt);
                        String usedate  = cursor.getString(4);
                        edit_usedate.setText(usedate);

                    }

                    Toast.makeText(M_already_Purchase.this, "검색완료!!!", Toast.LENGTH_SHORT).show();
                }
            });
    }


}
