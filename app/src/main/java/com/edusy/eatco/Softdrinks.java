package com.edusy.eatco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.edusy.eatco.Adapter.StoreBelowAdapter;
import com.edusy.eatco.DataModel.MainItemModels;

import java.util.ArrayList;

public class Softdrinks extends AppCompatActivity {


    RecyclerView RecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softdrinks);



        RecyclerView=findViewById(R.id.Recyclersoftdrink);

        ArrayList<MainItemModels> list2=new ArrayList<>();


        list2.add(new MainItemModels(R.drawable.sprite3,"Zera drinks","40","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite4,"Coca cola","50","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite9,"Butter scoch","120","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite13,"pepsi","10","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite1,"Sprite can","100","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite2,"Spritebottle","80","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite3,"Zera drinks","40","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite4,"Coca cola","50","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite9,"Butter scoch","120","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite13,"pepsi","10","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite1,"Sprite can","100","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite2,"Spritebottle","80","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite3,"Zera drinks","40","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite4,"Coca cola","50","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite9,"Butter scoch","120","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite13,"pepsi","10","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite1,"Sprite can","100","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite2,"Spritebottle","80","fresh and cold"));


















        StoreBelowAdapter storeBelowAdapter=new StoreBelowAdapter(list2,this);
        RecyclerView.setAdapter(storeBelowAdapter);


        LinearLayoutManager layoutManager2=new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(layoutManager2);

    }
}