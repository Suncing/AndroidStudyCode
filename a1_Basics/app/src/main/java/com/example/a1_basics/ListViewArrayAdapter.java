package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewArrayAdapter extends AppCompatActivity {

    String arr[] = {"Jay","Jarvis","Jerry","Jack","Amy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_array_adapter);

        //1.找到控件
        ListView lv3= findViewById(R.id.lv3);

        //2.创建一个arrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_list_view_array_adapter_inner,R.id.tvi,arr);

        //3.设置数组适配器
        lv3.setAdapter(adapter);
    }
}