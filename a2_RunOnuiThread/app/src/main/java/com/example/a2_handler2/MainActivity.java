package com.example.a2_handler2;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.gsm.SmsMessage.MessageClass;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private EditText et_path;
    private ImageView iv;
//    创建handler 对象
//	private Handler handler = new Handler(){
//		//处理消息
//		public void handleMessage(android.os.Message msg) {
//			Bitmap bitmap =  (Bitmap) msg.obj;
//			iv.setImageBitmap(bitmap);
//		};
//	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // [1]找到我们关心的控件
        et_path = (EditText) findViewById(R.id.et_path);
        iv = (ImageView) findViewById(R.id.iv);
    }

    // [2]点击按钮进行查看 指定路径的源码
    public void click(View v) {
        new Thread(){public void run() {
            try {
                //[2.1]获取访问图片的路径
                String path = et_path.getText().toString().trim();
                File  file = new File(getCacheDir(),Base64.encodeToString(path.getBytes(), Base64.DEFAULT));
                if (file.exists()&& file.length()>0) {
                    //使用缓存 的图片
                    System.out.println("使用缓存图片 ");
                    final Bitmap cacheBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    //把cacheBitmap 显示到iv上
//					 Message msg = Message.obtain();
//					 msg.obj = cacheBitmap;
//					 handler.sendMessage(msg); //发消息
                    runOnUiThread(new Runnable() {
                        public void run() {
                            iv.setImageBitmap(cacheBitmap);
                        }
                    });
                }else{
                    //第一次访问 联网获取数据
                    System.out.println("第一次访问连接网络");
                    //[2.2]创建url对象
                    URL url = new URL(path);
                    //[2.3]获取httpurlconnection
                    HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                    //[2.4]设置请求的方式
                    conn.setRequestMethod("GET");
                    //[2.5]设置超时时间
                    conn.setConnectTimeout(5000);
                    //[2.6]获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    if (code == 200) {
                        //[2.7]获取图片的数据  不管是什么数据(txt文本 图片数据 )都是以流的形式返回
                        InputStream in = conn.getInputStream();
                        //[2.7]缓存图片   谷歌给我们提供了一个缓存目录
                        FileOutputStream fos = new FileOutputStream(file);
                        int  len = -1;
                        byte[] buffer = new byte[1024];//1kb
                        while((len=in.read(buffer))!=-1){
                            fos.write(buffer, 0, len);
                        }
                        fos.close();
                        in.close();
                        //[2.8]通过位图工厂 获取bitmap(bitmap)
                        final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        //这句api 不 管你在什么位置上调用 action都运行在UI线程里
                        runOnUiThread(new Runnable() {
                            public void run() {
                                //run方法一定执行在UI线程 里
//							 [2.9]把bitmap显示到iv上
                                iv.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };}.start();
    }
}
