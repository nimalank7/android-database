package com.example.databasedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.databasedisplay.db.BookmarkAdapter;
import com.example.databasedisplay.db.BookmarkDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookmarkDataSource dataSource = new BookmarkDataSource(this);
        dataSource.open();
        BookmarkAdapter my_adapter = new BookmarkAdapter(dataSource.getAllBookmarks());
        System.out.println(my_adapter.dataset.get(0).getTitle()); // Debugging purposes
        setContentView(R.layout.activity_main); // Has to be before findViewByOd
        RecyclerView recycle_view = findViewById(R.id.recycle_view);

        recycle_view.setHasFixedSize(true);
        LinearLayoutManager layout_manager = new LinearLayoutManager(this);
        recycle_view.setLayoutManager(layout_manager);
        recycle_view.setAdapter(my_adapter);
        dataSource.close();
    }
}
