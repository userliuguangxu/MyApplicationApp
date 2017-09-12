package com.example.administrator.myapplication;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    private OkHttpUtils(){
        okHttpClient= new OkHttpClient();
    }
    public static synchronized OkHttpUtils getInstance(){
        if (okHttpUtils==null)
            okHttpUtils=new OkHttpUtils();
        return okHttpUtils;
    }
    public void sendget(String url, Callback callback){
        Request build = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(callback);
    }
}
