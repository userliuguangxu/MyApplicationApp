package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class List_View_Adapter extends BaseAdapter {
    List<Bean.NewBean> beanList;
    Context context;
    private ImageView img;
    private TextView title_item;

    public List_View_Adapter(List<Bean.NewBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);

        img =(ImageView)inflate.findViewById(R.id.img);
        title_item =(TextView)inflate.findViewById(R.id.title_item);
        Glide.with(context).load(beanList.get(i).getImg().get(0)).into(img);
        title_item.setText(beanList.get(i).getTitle());
        return inflate;
    }
}
