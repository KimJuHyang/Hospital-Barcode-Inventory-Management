package com.example.juhyang.hospital;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.app.Activity;
import android.os.Trace;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class M_InventoryStatus extends Activity {

    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_code, edit_name, edit_attr, edit_cnt, edit_usedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m__inventory_status);

        // DB search code
        helper = new dbHelper(this);
        try {
            db = helper.getWritableDatabase();
            //데이터베이스 객체를 얻기 위하여 getWritableDatabse()를 호출

        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }


        //버튼에 대한 클릭 처리기를 작성.

        //검색 버튼
        findViewById(R.id.see).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String resultp = " ";
                Cursor cursor;
                cursor = db.rawQuery("SELECT * FROM contact ", null);

                while(cursor.moveToNext()){
                    resultp += cursor.getString(0)
                        + "     "
                     + cursor.getString(2)
                     + "   "
                     + cursor.getString(3)
                     + "   "
                     + cursor.getString(4)
                     + "   "
                     + cursor.getString(5)
                    +"\n";
                }

                TextView resultview = (TextView) findViewById(R.id.result);
                resultview.setText(resultp);



            }
        });



    }

}
