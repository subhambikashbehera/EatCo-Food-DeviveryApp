package com.edusy.eatco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.edusy.eatco.Adapter.CartAdapter;
import com.edusy.eatco.DataModel.CartModel;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cart=findViewById(R.id.cart);

        getSupportActionBar().hide();


        DbHelper dbHelper=new DbHelper(this);
        ArrayList<CartModel> list =dbHelper.getorders();



        CartAdapter cartAdapter=new CartAdapter(list,this);
        cart.setAdapter(cartAdapter);

                LinearLayoutManager layoutManager=new LinearLayoutManager(this);
                cart.setLayoutManager(layoutManager);











    }
}