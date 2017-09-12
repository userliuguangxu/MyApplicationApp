package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;




/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class Roll_View_Adapter extends StaticPagerAdapter {
    Context context;
    List<String> imgs;
    private ImageView img;

    public Roll_View_Adapter(Context context, List<String> imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.img_item, null);

        img =(ImageView)inflate.findViewById(R.id.img);
        Glide.with(context).load(imgs.get(position)).into(img);
        return inflate;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }
}
