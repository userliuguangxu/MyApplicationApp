package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

import java.util.List;

public class Main3Activity extends AppCompatActivity implements Have{


    private TextView content_item;
    private String content;
    private RollPagerView roll_view;
    private List<String> imgs;
    private Roll_View_Adapter roll_view_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {

        content_item = (TextView) findViewById(R.id.content_item);
        roll_view = (RollPagerView) findViewById(R.id.roll_view);

    }


    @Override
    public void send(List<String> imgs, String content) {
//        Intent intent = getIntent();
//        content = intent.getStringExtra("content");
//        imgs = intent.getParcelableExtra("imgs");
        roll_view_adapter = new Roll_View_Adapter(Main3Activity.this, imgs);
        roll_view.setPlayDelay(1000);
        roll_view.setAdapter(roll_view_adapter);
    }
}
