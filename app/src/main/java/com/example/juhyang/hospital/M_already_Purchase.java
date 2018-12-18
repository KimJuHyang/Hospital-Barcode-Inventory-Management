package com.example.juhyang.hospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
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
                    String cnt = edit_cnt.getText().toString();
                    Cursor cursor;
                    cursor = db.rawQuery("SELECT code, name, attr, cnt, usedate FROM contact where code='"+code+"';" , null);

                    while(cursor.moveToNext()){
                        String name = cursor.getString(1);
                        edit_name.setText(name);
                        String attr = cursor.getString(2);
                        edit_attr.setText(attr);
                        String usedate  = cursor.getString(4);
                        edit_usedate.setText(usedate);

                    }
                }
            });



        ImageView a = (ImageView) findViewById(R.id.add);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = edit_code.getText().toString();
                String cnt = edit_cnt.getText().toString();

                db.execSQL("UPDATE contact SET cnt='" +cnt+ "' where code='" + code + "';");

                Toast.makeText(M_already_Purchase.this, "새롭게 등록 완료!!!", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //여기에 딜레이 후 시작할 작업들을 입력
                        Intent go = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                login.class); // 다음 넘어갈 클래스 지정
                        startActivity(go); // 다음 화면으로 넘어간다
                    }
                }, 500);// 0.5초 정도 딜레이를 준 후 시작
            }
        });



    }


}
