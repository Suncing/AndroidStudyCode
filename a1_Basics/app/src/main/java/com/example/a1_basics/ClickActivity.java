package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClickActivity extends AppCompatActivity implements View.OnClickListener {

    private Button secondClick;
    private Button btn_thridClick1;
    private Button btn_thridClick2;
    private Button fourthClick;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        btn_thridClick1 = findViewById(R.id.thridClick1);
        btn_thridClick1.setOnClickListener(this);
        btn_thridClick2 = findViewById(R.id.thridClick2);
        btn_thridClick2.setOnClickListener(this);

        fourthClick = findViewById(R.id.fourthClick);
        fourthClick.setOnClickListener(new MyClickListener());

        //2.第二种，匿名内部类
        secondClick = findViewById(R.id.secondClick);
        secondClick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(ClickActivity.this,"第二种成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //1.第一种,xml中设置onclick
    public void testOnClick(View view) {
        Toast.makeText(ClickActivity.this,"第一种成功",Toast.LENGTH_SHORT).show();
    }


    //3.第三种，让所在类实现OnClickListener接口，重写其中方法
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.thridClick1:
                System.out.println("1");
                break;
            case R.id.thridClick2:
                System.out.println("2");
                break;
        }
    }

    //4.第四种，定义一个类
    private class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(ClickActivity.this,"第四种成功",Toast.LENGTH_SHORT).show();
        }
    }

}
