package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    private EditText et_contents;
    private Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        et_contents = findViewById(R.id.et_tel);

        btn_call = findViewById(R.id.btn_clickCall);
        btn_call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String numbers = et_contents.getText().toString().trim();
                if("".equals(numbers)){
                    Toast.makeText(CallActivity.this,"你输入的号码为空！",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(CallActivity.this,"拨打的电话号码是："+numbers,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+numbers));
                    startActivity(intent);
                }
            }
        });
    }

}
