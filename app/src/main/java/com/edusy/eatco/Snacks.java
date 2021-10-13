package com.edusy.eatco;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edusy.eatco.Adapter.StoreBelowAdapter;
import com.edusy.eatco.DataModel.MainItemModels;

import java.util.ArrayList;

public class Snacks extends AppCompatActivity {



    RecyclerView RecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);


        RecyclerView=findViewById(R.id.Recyclersnack);

        ArrayList<MainItemModels> list2=new ArrayList<>();

        list2.add(new MainItemModels(R.drawable.b1,"Small Chips","125","Meaty portobello mushroom makes for the perfect Vegeterian Burger"));
        list2.add(new MainItemModels(R.drawable.b8,"Indian masal chips","80","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.pizza,"Pizza","120","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.sweet,"Rosogala","10","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.fishfry,"Fish FRY","80","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.gupchup,"gupchup","10","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.paobhaji,"pao bhaji","130","fresh and newly made for you with new oil"));

        list2.add(new MainItemModels(R.drawable.samosa,"Somosa","40","fresh and newly made for you with new oil"));


        list2.add(new MainItemModels(R.drawable.tomato,"Tomato","30","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.patato,"Potato","40","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.onion,"Onion","60","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.carrot,"Carrot","30","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.edibleleaves,"Foliage","20","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.bittergourd,"BitterGroud","35","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.mango,"Mango","40","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.apple,"Apple","110","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.banana,"Banana","65","fresh and home fertilized"));













        StoreBelowAdapter storeBelowAdapter=new StoreBelowAdapter(list2,this);
        RecyclerView.setAdapter(storeBelowAdapter);


        LinearLayoutManager layoutManager2=new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(layoutManager2);

    }

}