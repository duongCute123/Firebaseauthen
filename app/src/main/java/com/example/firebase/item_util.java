package com.example.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class item_util extends BaseAdapter {
    int layout;
    List<Giay> giays;
    Context context;

    public item_util(int layout, List<Giay> giays, Context context) {
        this.layout = layout;
        this.giays = giays;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(layout,viewGroup,false);
        TextView txt_1=view.findViewById(R.id.txt_1);
        TextView txt_2=view.findViewById(R.id.txt_2);
        TextView txt_3=view.findViewById(R.id.txt_3);
        ImageView btn_img=view.findViewById(R.id.btn_img);
        txt_1.setText(giays.get(i).getTen());
        txt_2.setText(giays.get(i).getNhaSX());
        txt_3.setText(Double.toString(giays.get(i).getGia()));
        btn_img.setImageResource(giays.get(i).getImg());
        return view;
    }
}
