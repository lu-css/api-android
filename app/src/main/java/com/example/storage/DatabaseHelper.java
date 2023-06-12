package com.example.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.models.History;

import java.util.ArrayList;

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

    public History getLastHistory(){
        SQLiteDatabase db = this.getReadableDatabase();

        // Searches for the last added item in history.
        String query = String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT 1", DB.TABLE_HISTORY, DB.COLUMN_HISTORY_ID);

        // Runs the query.
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        // Id From Field.
        int index = cursor.getColumnIndex(DB.COLUMN_HISTORY_ID);
        int id = cursor.getInt(index);

        // MoneyFrom Field.
        index = cursor.getColumnIndex(DB.COLUMN_HISTORY_MONEY_FROM);
        String money_from = cursor.getString(index);

        // MoneyTo Field.
        index = cursor.getColumnIndex(DB.COLUMN_HISTORY_MONEY_TO);
        String money_to = cursor.getString(index);

        // Builds the History object.
        return new History(id, money_from, money_to);
    }

    public ArrayList<History> getAllHistoryItens(){
        ArrayList<History> histories = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String query = String.format("SELECT * FROM %s ORDER BY %s DESC", DB.TABLE_HISTORY, DB.COLUMN_HISTORY_ID);

        // Runs the query.
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            History history = new History(); 
            int index;

            // index = cursor.getColumnIndex(DB.COLUMN_HISTORY_ID);

            // MoneyFrom Field.
            index = cursor.getColumnIndex(DB.COLUMN_HISTORY_MONEY_FROM);
            history.moneyFrom = cursor.getString(index);

            // MoneyTo Field.
            index = cursor.getColumnIndex(DB.COLUMN_HISTORY_MONEY_TO);
            history.moneyTo = cursor.getString(index);

            histories.add(history);
            cursor.moveToNext();
        }

        cursor.close();

        return histories;
    }
}
