package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Mainstart extends AppCompatActivity {
    ListView list_view;
    ArrayList<Giay> item_entities;
    item_util item_utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstart);
//        list_view=findViewById(R.id.list_view);
//        item_entities=new ArrayList<>();
//        item_entities.add(new Giay("Giày cao cấp addad","Nhà sản xuất:Thanh Hóa",300.000,
//                R.drawable.shoes_rm_yellow));
//        item_entities.add(new Giay("Giày cao cấp addad","Nhà sản xuất:Thanh Hóa",300.000,
//                R.drawable.shoes_rm_preview_a));
//        item_entities.add(new Giay("Giày cao cấp addad","Nhà sản xuất:Thanh Hóa",300.000,
//                R.drawable.shoes_rm_purple));
//        item_entities.add(new Giay("Giày cao cấp addad","Nhà sản xuất:Thanh Hóa",300.000,
//                R.drawable.shoes_rm_yellow));
//        item_utils=new item_util(R.layout.customer_list_view,item_entities,this);
//        list_view.setAdapter(item_utils);
        Intent intent=new Intent(Mainstart.this,them_du_lieu.class);
        startActivity(intent);
    }
}