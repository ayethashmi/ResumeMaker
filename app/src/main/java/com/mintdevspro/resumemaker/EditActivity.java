package com.mintdevspro.resumemaker;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EditActivity extends AppCompatActivity {
    ArrayList<File> arrylist;
    EditCvAdapter editCvAdapter;
    ImageView ivBackArrow;
    RecyclerView.LayoutManager layoutmanager;
    File path;
    RecyclerView recyclerView;

    
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_edit);

        this.ivBackArrow = (ImageView) findViewById(R.id.img_resultArrows);
        this.path = new ContextWrapper(getApplicationContext()).getDir("Created CV", 0);
        Log.d("gggg", "pathdata" + this.path);
        File[] listFiles = new File(String.valueOf(this.path)).listFiles();
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recler_id);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.layoutmanager = new LinearLayoutManager(this);
        ArrayList<File> arrayList = new ArrayList<>();
        this.arrylist = arrayList;
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
            Collections.reverse(this.arrylist);
            this.recyclerView.setLayoutManager(this.layoutmanager);
            this.editCvAdapter = new EditCvAdapter(this, this.arrylist);
            this.recyclerView.setVisibility(View.VISIBLE);
            this.editCvAdapter.notifyDataSetChanged();
            this.recyclerView.setAdapter(this.editCvAdapter);
            Log.d("dataarray", "" + listFiles.length);
        }
        this.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditActivity.this.finish();
            }
        });
    }
}
