package com.example.databasedisplay.db;

import android.provider.BaseColumns;

public class BookMarkContract {
    private BookMarkContract() {};

    static final String CREATE_BOOKMARK_TABLE = "CREATE TABLE " + Bookmark.TABLE_NAME +
            "( " + Bookmark._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Bookmark.COLUMN_NAME + " TEXT)";

    public static class Bookmark implements BaseColumns {
        public static final String TABLE_NAME = "Bookmark";
        public static final String COLUMN_NAME = "title";
    }
}
