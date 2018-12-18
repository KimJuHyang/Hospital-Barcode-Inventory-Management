package com.example.juhyang.hospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class P_Used extends Activity {

    dbHelper_sick helper;
    SQLiteDatabase db;
    EditText edit_code, edit_name, edit_date, edit_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__used);

        //클릭시 다음화면 넘어가기
        ImageView b = (ImageView) findViewById(R.id.addused);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent change = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        P_Purchase.class); // 다음 넘어갈 클래스 지정
                        change.putExtra("istype","nomal");
                startActivity(change);
            }
        });

        // DB search code
        helper = new dbHelper_sick(this);
        try {
            db = helper.getWritableDatabase();
            //데이터베이스 객체를 얻기 위하여 getWritableDatabse()를 호출

        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }

        edit_code = (EditText) findViewById(R.id.sickcode);
        edit_name = (EditText) findViewById(R.id.name);
        edit_date = (EditText) findViewById(R.id.date);
        edit_gender = (EditText) findViewById(R.id.gender);

        //환자 데이터 미리 삽입하기

        //버튼에 대한 클릭 처리기를 작성.

        //검색 버튼
        findViewById(R.id.searchsick).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String code = edit_code.getText().toString();
                Cursor cursor;
                cursor = db.rawQuery("SELECT code, name, date, gender FROM sick where code='"+code+"';" , null);

                while(cursor.moveToNext()){
                    String name = cursor.getString(1);
                    edit_name.setText(name);
                    String date = cursor.getString(2);
                    edit_date.setText(date);
                    String gender = cursor.getString(3);
                    edit_gender.setText(gender);

                }

                Toast.makeText(P_Used.this, "검색완료!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
