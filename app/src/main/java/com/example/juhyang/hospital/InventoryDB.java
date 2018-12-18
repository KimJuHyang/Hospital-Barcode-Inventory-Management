package com.example.juhyang.hospital;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


class dbHelper extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION =1;


    /*
     *먼저 SQLiteOpenHelper클래스를 상속받은 dbHelper클래스가 정의 되어 있다. 데이터베이스 파일 이름은 "mycontacts.db"가되고,
     *데이터베이스 버전은 1로 되어있다. 만약 데이터베이스가 요청되었는데 데이터베이스가 없으면 onCreate()를 호출하여 데이터베이스
     *파일을 생성해준다.
     */

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contact " + "(id INTEGER PRIMARY KEY,code TEXT, name TEXT, attr TEXT, cnt TEXT, made TEXT, maneger TEXT, phone TEXT, " +
                "usedate TEXT)");
        db.execSQL("INSERT INTO contact VALUES(null, '1','테스트','테스트','100',null,null,null,null);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("");
        onCreate(db);
    }



}
