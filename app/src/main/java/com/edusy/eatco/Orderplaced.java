package com.edusy.eatco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Orderplaced extends AppCompatActivity {

            Button orderplaced;
            ImageButton orderplaced2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplaced);
        orderplaced=findViewById(R.id.orderplaced);
        orderplaced2=findViewById(R.id.orderplacedtwo);



        orderplaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Orderplaced.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        orderplaced2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Orderplaced.this,Cart.class);
                startActivity(intent);
                finish();

            }
        });

    }






}