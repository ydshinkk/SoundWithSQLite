package com.mobile.soundwithsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "test.db";

    // DBHelper 생성자
    public DBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    // Sound Table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Sound(date INT, num INT)");
    }

    // Sound Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Sound");
        onCreate(db);
    }

    // Sound Table 데이터 입력
    public void insert(int date, int num) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Sound VALUES('" + date + "', " + num + ");");
        db.close();
    }

    // Sound Table 데이터 수정
    public void Update(int date, int num) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Sound SET num = " + num + " WHERE date = '" + date + "'");
        db.close();
    }

    // Sound Table 조회
    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM Sound", null);
        while (cursor.moveToNext()) {
            result += "s" + cursor.getInt(0)
                    + "n"
                    + cursor.getInt(1)
                    + "\n";
        }

        return result;
    }

    public String getResultDec() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // 쿼리문과 Cursor를 사용하여 원하는 데이터 출력
        Cursor cursor = db.rawQuery("SELECT num FROM Sound WHERE (date-221200)>0 ORDER BY date ASC", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0) + "-";
        }

        return result;
    }

}