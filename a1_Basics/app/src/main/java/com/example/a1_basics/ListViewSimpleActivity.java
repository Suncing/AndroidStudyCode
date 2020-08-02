package com.example.a1_basics;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewSimple extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView lv = findViewById(R.id.lv);//找到我们关心的控件
        lv.setAdapter(new MyListenerAdapter());//数据来源于适配器，和其他普通控件textview有区别

    }

    public class MyListenerAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 600000000;//屏幕显示多少条数
            //注意，若使用包裹内容会多显示，因为android会不断确认是否包裹住了。所以不推荐时间wrap_content
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            TextView tv;

//            1.这样会报警告，因为吃内存
//            Log.d("ListViewTest",":"+position);
//            tv = new TextView(ListViewTest.this);
//            tv.setText("哈哈"+position);
//
//            2.使用对象复用，解决
            if(view == null){
                tv = new TextView(ListViewSimple.this);
                Log.d("ListViewTest",":新对象"+position);
            }else{
                tv= (TextView) view;
                Log.d("ListViewTest",":复用历史对象对象"+position);
            }
            tv.setText("哈哈"+position);

            return tv;
        }
    }
}
