package com.aditi.yelp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Currency;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context) {
        super(context, "fav.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE fav ( id INTEGER PRIMARY KEY AUTOINCREMENT, place TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS fav");
        onCreate(sqLiteDatabase);
    }


    public void insertFav(String f){

        getReadableDatabase().rawQuery(String.format("INSERT INTO fav (place) VALUES ('%s')",f), null);
    }


    public ArrayList<String> getFav(){
        ArrayList<String> data = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM fav", null);

        while (c.moveToNext()){

            data.add(c.getString(c.getColumnIndex("place")));
        }

        return data;
    }
}
