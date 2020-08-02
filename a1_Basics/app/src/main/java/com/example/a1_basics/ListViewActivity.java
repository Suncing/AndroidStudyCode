package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


    }

    public void turnListViewSimple(View view) {
        Intent intent = new Intent();
        intent.setClass(ListViewActivity.this,ListViewSimpleActivity.class);
        startActivity(intent);
    }

    public void turnListViewDifficult(View view) {
        Intent intent = new Intent();
        intent.setClass(ListViewActivity.this,ListViewDifficultActivity.class);
        startActivity(intent);
    }

    public void turnArrayAdapter(View view) {
        Intent intent = new Intent();
        intent.setClass(ListViewActivity.this,ListViewArrayAdapter.class);
        startActivity(intent);
    }

    public void turnSimpleAdapter(View view) {
        Intent intent = new Intent();
        intent.setClass(ListViewActivity.this,ListViewSimpleAdapter.class);
        startActivity(intent);
    }
}