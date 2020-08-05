package com.example.a1_basics;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(R.mipmap.Jay);
        setContentView(frameLayout);

        //设置TextView
        TextView text = new TextView(this);
        text.setText("开始游戏");
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        text.setTextColor(Color.rgb(17,85,114));

        //设置文本包裹内容和居中
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity= Gravity.CENTER;
        text.setLayoutParams(params);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")
                        .setMessage("游戏有风险，真的要进入吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("桌面台球","进入游戏");
                            }
                        }).setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("桌面台球","退出游戏");
                        finish();
                    }
                }).show();
            }
        });
        frameLayout.addView(text);



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
