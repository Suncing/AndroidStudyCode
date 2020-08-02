package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_toast = this.findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new ToastClickListener());

    }
    private class ToastClickListener implements View.OnClickListener{
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,TestToast.class);
            startActivity(intent);
        }
    }
}