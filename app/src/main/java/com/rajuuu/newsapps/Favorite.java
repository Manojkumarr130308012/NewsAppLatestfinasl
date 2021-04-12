package com.rajuuu.newsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adapter.LatestAdapter;
import com.example.favorite.DatabaseHelper;
import com.example.item.ItemLatest;

import java.util.ArrayList;

public class Favorite extends AppCompatActivity {
    ArrayList<ItemLatest> mListItem;
    public RecyclerView recyclerView;
    LatestAdapter adapter;
    private LinearLayout lyt_not_found;
    DatabaseHelper databaseHelper;
    TextView no_fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        mListItem = new ArrayList<>();
        databaseHelper = new DatabaseHelper(Favorite.this);
        lyt_not_found = findViewById(R.id.lyt_not_found);
        recyclerView = findViewById(R.id.vertical_courses_list);
        no_fav = findViewById(R.id.no_fav);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(Favorite.this, 1));
        recyclerView.setFocusable(false);
    }

    private void displayData() {

        adapter = new LatestAdapter(Favorite.this, mListItem);
        recyclerView.setAdapter(adapter);

        if (adapter.getItemCount() == 0) {
            lyt_not_found.setVisibility(View.VISIBLE);
            no_fav.setText(getString(R.string.no_favorite));
        } else {
            lyt_not_found.setVisibility(View.GONE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mListItem = databaseHelper.getFavourite();
        displayData();
    }
}