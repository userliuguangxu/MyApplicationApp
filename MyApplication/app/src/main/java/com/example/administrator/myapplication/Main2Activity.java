package com.example.administrator.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private ListView list_View;
    List<Bean.NewBean> beanList = new ArrayList<>();
    private List_View_Adapter list_view_adapter;
    List<String> viewpager_urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
        initAdapter();
        initLinstener();
    }

    private void initLinstener() {
        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                new Have() {
                    @Override
                    public void send(List<String> imgs, String content) {
                        imgs=viewpager_urls;
                        content=beanList.get(i).getContent();
                    }
                };

                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        list_view_adapter = new List_View_Adapter(beanList, Main2Activity.this);
        list_View.setAdapter(list_view_adapter);
    }

    private void initData() {
        OkHttpUtils.getInstance().sendget("http://192.168.0.176:8080/data_a.json", new Callback() {

            private String string=null;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string = response.body().string();
                runOnUiThread(new Runnable() {

    @Override
    public void run() {
        if (string!=null){
            Gson gson = new Gson();
            final Bean bean =  gson.fromJson(string, Bean.class);

            List<String> viewpager_url = bean.getViewpager_url();
        viewpager_urls.addAll(viewpager_url);
            List<Bean.NewBean> newX = bean.getNewX();
            beanList.addAll(newX);
            list_view_adapter.notifyDataSetChanged();
        }

    }
});
            }
        });
    }

    private void initView() {
        list_View = (ListView) findViewById(R.id.list_View);
    }


}
