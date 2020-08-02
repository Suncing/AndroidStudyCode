package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
    }

    public void itemsMethod(View view) {
        Intent intent = new Intent();
        intent.setClass(ActionBarActivity.this,ActionBarItemActivity.class);
        startActivity(intent);
    }

    public void viewsMethod(View view) {
        Intent intent = new Intent();
        intent.setClass(ActionBarActivity.this,ActionBarViewActivity.class);
        startActivity(intent);
    }
}
