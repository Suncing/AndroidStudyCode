package com.example.a2_handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StremTools {
    public static String readStream(InputStream in) throws IOException {
        //定义一个内存输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffers = new byte[1024];
        while((len=in.read(buffers))!=-1){
            byteArrayOutputStream.write(buffers);
        }
        in.close();
        //
        String context = new String(byteArrayOutputStream.toByteArray());
        return context;
    }


}
