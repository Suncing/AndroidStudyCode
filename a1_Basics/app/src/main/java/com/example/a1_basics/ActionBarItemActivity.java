package com.example.a1_basics;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class ActionBarItemActivity extends AppCompatActivity {


    private Button btn_dispaly;
    private Button btn_undispaly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_item);

        final ActionBar actionBar = getSupportActionBar();
        btn_dispaly = findViewById(R.id.dispaly);
        btn_undispaly = findViewById(R.id.undisplay);

        btn_dispaly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionBar.show();
            }
        });
        btn_undispaly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionBar.hide();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();//实例化一个MenuInflater对象
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
