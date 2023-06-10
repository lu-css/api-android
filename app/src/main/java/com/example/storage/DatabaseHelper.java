package com.example.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

abstract class DB{
    public static final String TABLE_HISTORY = "tb_history";
    public static final String COLUMN_HISTORY_MONEY_FROM = "money_from";
    public static final String COLUMN_HISTORY_MONEY_TO = "money_to";
    public static final String COLUMN_HISTORY_ID = "history_id";
}

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_everyday";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = String.format
                ("create table %s (%s integer primary key autoincrement, %s text, %s text)",
                DB.TABLE_HISTORY, DB.COLUMN_HISTORY_ID, DB.COLUMN_HISTORY_MONEY_FROM, DB.COLUMN_HISTORY_MONEY_TO);

        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB.TABLE_HISTORY);

        onCreate(sqLiteDatabase);
    }

    public boolean addHistory(String from, String to){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues content = new ContentValues();

        content.put(DB.COLUMN_HISTORY_MONEY_TO, to);
        content.put(DB.COLUMN_HISTORY_MONEY_FROM, from);

        boolean success = db.insert(DB.TABLE_HISTORY, null, content) > 0;

        return success;
    }
}
