package com.example.a2_handler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final int REQUESSUCCESS = 0;
    private static final int REQUESTFAIL = 1;
    private static final int REQUESTEXPECTION = 2;
    private EditText mPath;
    private TextView mResult;
    //解决子线程不能直接更新ui
    //new后面跟大括号表示要重写其中的方法了
    private Handler handler = new Handler(){
        //这个方法是在主线程里面执行的，就可以更新ui了
        public void handleMessage(Message msg) {//这个msg是刚才发送的数据
            super.handleMessage(msg);

            switch (msg.what){
                case REQUESSUCCESS:
                    String context = (String) msg.obj;
                    mResult.setText(context);
                    break;
                case REQUESTFAIL:
                    Toast.makeText(getApplicationContext(),"资源不存在",Toast.LENGTH_SHORT).show();
                    break;
                case REQUESTEXPECTION:
                    Toast.makeText(getApplicationContext(),"服务器繁忙，请稍后",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPath = findViewById(R.id.path);
        mResult = findViewById(R.id.result);
    }

    public void click(View view)  {
        new Thread(){
            public void run() {
                String path = mPath.getText().toString().trim();
                try {
                    URL url = new URL(path);
                    //拿到HttpURLConnection 用于发送请求数据
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    if(conn.getResponseCode()==200){
                        //由于把流装换成字符串是常见操作，所以抽出为方法
                        InputStream in = conn.getInputStream();

                        //使用定义的工具类把in转换成String
                        String context = StremTools.readStream(in);

                        //Message可以携带数据
                        //Message msg = new Message(); 使用obtain会减少对象的创建
                        Message msg = new Message();
                        msg.what=REQUESSUCCESS;
                        msg.obj=context;

                        //拿着创建的handler告诉系统要更新ui，发了一条消息msg，handleMessage方法就会执行
                        handler.sendMessage(msg);
                        mResult.setText(context);
                    }else{
                        //请求资源不存在 Toast也是view 不能在子线程更新ui
                        //Message msg = new Message();  不如Message.obtain()方法效率高
                        //假设发送图片 ：msg.obj = image;
                        //handler里面接收：Image image =(Image) msg.obj;

                        Message msg = Message.obtain();
                        msg.what=REQUESTFAIL;//代表哪条消息
                        handler.sendMessage(msg);

                    }
                }catch (Exception e){
                    e.printStackTrace();

                    Message msg = Message.obtain();
                    msg.what=REQUESTEXPECTION;//代表哪条消息
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }
}