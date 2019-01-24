package com.example.databasedisplay.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BookmarkDataSource {
    private static final String NAME = BookmarkDataSource.class.getSimpleName();
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public BookmarkDataSource(Context context) {
        this.dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        this.database = dbHelper.getWritableDatabase();
        Log.d(NAME, "database is opened"); // Log statement to open database
    }

    public void close(){
        dbHelper.close();
        Log.d(NAME, "database is closed"); // Log statement to close database
    }

    public List<Bookmark> getAllBookmarks(){
        List<Bookmark> bookmarks = new ArrayList<>();
        String selectQuery = "SELECT * FROM bookmark";
        Cursor cursor = database.rawQuery(selectQuery, null);
        System.out.println("Getting number of columns");
        System.out.println(cursor.getColumnCount());
        System.out.println("Getting number of rows");
        System.out.println(cursor.getCount());
        while(cursor.moveToNext()){
            Bookmark i_bookmark = new Bookmark(cursor.getInt(cursor.getColumnIndex(BookMarkContract.Bookmark._ID)),
                    cursor.getString(cursor.getColumnIndex(BookMarkContract.Bookmark.COLUMN_NAME)));
            bookmarks.add(i_bookmark);
        }
        cursor.close();
        System.out.println(bookmarks.get(0).getTitle());
        System.out.println(bookmarks.get(0).getId());
        System.out.println(bookmarks.get(1).getTitle());
        System.out.println(bookmarks.get(1).getId());

        return bookmarks;
    }

}
