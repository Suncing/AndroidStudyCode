package com.example.a1_basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestToast extends AppCompatActivity {
    private static final String TAG="TestToast";
    String contents;
    private Button btn_toast_imp;
    private EditText text_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast);
        btn_toast_imp = findViewById(R.id.btn_toast_imp);
        text_toast = findViewById(R.id.text_toast);
        btn_toast_imp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                contents = text_toast.getText().toString().trim();
                if("".equals(contents)){
                    Toast.makeText(TestToast.this,"你输入的号码为空",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(TestToast.this,"你输入的号码"+contents+"拨打成功！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}