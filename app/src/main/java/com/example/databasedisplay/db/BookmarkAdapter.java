package com.example.databasedisplay.db;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.databasedisplay.R;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {
    public List<Bookmark> dataset;

    public BookmarkAdapter(List<Bookmark> dataset){
        this.dataset = dataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ViewHolder(TextView name){
            super(name);
            title = name;
        }
    }
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position){
        Bookmark bookmark = dataset.get(position);
        holder.title.setText(bookmark.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.dataset.size();
    }

}
