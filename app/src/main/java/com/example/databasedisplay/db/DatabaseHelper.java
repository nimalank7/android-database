package com.example.databasedisplay.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bookmarks_data1.db";
    private static final int VERSION_NUMBER = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BookMarkContract.CREATE_BOOKMARK_TABLE);
        db.execSQL("INSERT INTO Bookmark (title) VALUES('google')");
        db.execSQL("INSERT INTO Bookmark (title) VALUES('yahoo')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BookMarkContract.Bookmark.TABLE_NAME);
        onCreate(db);
    }
}
