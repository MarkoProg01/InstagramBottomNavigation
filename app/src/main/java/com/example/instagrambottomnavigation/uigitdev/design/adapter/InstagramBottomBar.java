package com.example.instagrambottomnavigation.uigitdev.design.adapter;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagrambottomnavigation.R;
import com.example.instagrambottomnavigation.model.BottomItem;

import java.util.ArrayList;

public class InstagramBottomBar {
    private final int ITEM_LIMIT = 5;
    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<BottomItem> bottomItems;
    private com.example.instagrambottomnavigation.uigitdev.design.adapter.BottomAdapter.BottomItemClickInterface bottomItemClickInterface;

    public InstagramBottomBar(View view, Context context, com.example.instagrambottomnavigation.uigitdev.design.adapter.BottomAdapter.BottomItemClickInterface bottomItemClickInterface) {
        this.context = context;
        this.bottomItemClickInterface = bottomItemClickInterface;
        setType(view);
    }

    private void setType(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        bottomItems = new ArrayList<>();
    }

    public void addBottomItem(BottomItem item) {
        if (bottomItems.size() != ITEM_LIMIT) {
            bottomItems.add(item);
        }
    }

    private void setAdapter(int selected) {
        com.example.instagrambottomnavigation.uigitdev.design.adapter.BottomAdapter bottomAdapter = new com.example.instagrambottomnavigation.uigitdev.design.adapter.BottomAdapter(selected, bottomItems, calculateItemWidth(), bottomItemClickInterface);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(bottomAdapter);
    }

    private int calculateItemWidth() {
        int mCount = bottomItems.size() + 1;
        int mWidth = context.getResources().getDisplayMetrics().widthPixels;
        return mWidth / mCount;
    }

    public void apply(int selected) {
        setAdapter(selected);
    }
}
