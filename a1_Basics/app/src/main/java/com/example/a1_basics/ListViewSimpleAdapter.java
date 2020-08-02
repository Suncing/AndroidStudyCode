package com.example.a1_basics;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewSimpleAdapter extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple_adapter);

        ListView lvs = findViewById(R.id.lvs);

        List<Map<String,String>> data = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("name","张飞");
        map1.put("phone","1322222");
        Map<String,String> map2 = new HashMap<>();
        map1.put("name","张飞");
        map1.put("phone","1322222");
        Map<String,String> map3 = new HashMap<>();
        map1.put("name","张飞");
        map1.put("phone","1322222");
        Map<String,String> map4 = new HashMap<>();
        map1.put("name","张飞");
        map1.put("phone","1322222");
        data.add(map1);data.add(map2);data.add(map3);data.add(map4);

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),data,R.layout.activity_list_view_simple_adapter_inner,
                new String[]{"name","phone"},new int[]{R.id.tvname,R.id.tvvalue});

        lvs.setAdapter(adapter);


    }
}
