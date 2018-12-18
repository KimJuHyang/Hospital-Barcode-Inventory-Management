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


class dbHelper_sick extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "sick.db";
    private static final int DATABASE_VERSION = 1;


    /*
     *먼저 SQLiteOpenHelper클래스를 상속받은 dbHelper클래스가 정의 되어 있다. 데이터베이스 파일 이름은 "mycontacts.db"가되고,
     *데이터베이스 버전은 1로 되어있다. 만약 데이터베이스가 요청되었는데 데이터베이스가 없으면 onCreate()를 호출하여 데이터베이스
     *파일을 생성해준다.
     */

    public dbHelper_sick(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE sick " + "(id INTEGER PRIMARY KEY, code TEXT, name TEXT, date TEXT, gender TEXT, medicode TEXT, medi TEXT, mediattr TEXT)");
        db.execSQL("INSERT INTO sick VALUES(null, '100','김주향','1997-10-24','여',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '200','한대희','1999-05-12','남',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '300','신솔찬','1997-03-15','남',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '700','정지연','1997-11-14','여',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '800','권보경','1997-05-15','여',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '400','최은주','1997-12-15','여',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '500','이수진','1997-05-22','여',null,null,null);");
        db.execSQL("INSERT INTO sick VALUES(null, '600','이진주','1997-02-18','여',null,null,null);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("");
        onCreate(db);
    }



}
