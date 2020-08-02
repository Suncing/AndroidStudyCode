package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListViewDifficultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_difficult);
        ListView lv2 = findViewById(R.id.lv2);
        lv2.setAdapter(new MyListenerAdapter2());
    }


    public class MyListenerAdapter2 extends BaseAdapter{

        @Override
        public int getCount() {
            return 7;
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
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view;
            if(convertView==null){
                //创建新的view对象，可以用打气筒把一个布局资源文件转换成一个view对象
                //第一个参数就是上下文，第二个参数是定义的布局文件，第三个参数就是把转换成view对象后的资源文件加入ViewGroup中

                //1.写法
                view = View.inflate(getApplicationContext(),R.layout.activity_list_view_difficult_inner,null);

                //2.写法
                //view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_list_view_difficult_inner,null);

                //3.写法
                //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                //view = inflater.inflate(R.layout.activity_list_view_difficult_inner,null);




            }else{
                view = convertView;
            }
            return view;
        }
    }
}