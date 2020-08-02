package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void turnCall(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,CallActivity.class);
        startActivity(intent);
    }

    public void turnClick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,ClickActivity.class);
        startActivity(intent);
    }

    public void turnActionBar(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ActionBarActivity.class);
        startActivity(intent);
    }

    public void turnListView(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }
}
