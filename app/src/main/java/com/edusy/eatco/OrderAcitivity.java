package com.edusy.eatco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderAcitivity extends AppCompatActivity {


    TextView ordername,orderdescription,orderprice,quantity;
    EditText personname,personphonenumber,address;
    Button ordernow;
    ImageView orderimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_acitivity);

        ordername=findViewById(R.id.ordername);
        orderdescription=findViewById(R.id.orderdescription);
        orderprice=findViewById(R.id.orderprice);
        personname=findViewById(R.id.personname);
        personphonenumber=findViewById(R.id.personphonenumber);
        address=findViewById(R.id.address);
        ordernow=findViewById(R.id.ordernow);
        orderimage=findViewById(R.id.orderimage);
        quantity=findViewById(R.id.count);



       final int image=getIntent().getIntExtra("image",0);
       final int price=Integer.parseInt(getIntent().getStringExtra("price"));
       final String name=getIntent().getStringExtra("name");
      final  String description=getIntent().getStringExtra("description");


        orderimage.setImageResource(image);
        orderprice.setText(String.format("%d",price));
        ordername.setText(name);
        orderdescription.setText(description);

        DbHelper dbHelper=new DbHelper(this);



        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1=personname.getText().toString().trim();
                String phone1=personphonenumber.getText().toString().trim();
                String addrress1=address.getText().toString().trim();

                if (TextUtils.isEmpty(name1))
                {
                    personname.setError("Enter the name");

                }
                if (TextUtils.isEmpty(phone1))
                {
                    personphonenumber.setError("Enter the phone number");
                }
                if (TextUtils.isEmpty(addrress1))
                {
                    address.setError("Enter the Address");
                }

                if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(phone1) || TextUtils.isEmpty(addrress1) )

                {
                    Toast.makeText(OrderAcitivity.this," Enter the Details",Toast.LENGTH_SHORT).show();
                }
                else {

                    boolean isInserted=dbHelper.insertOrder(personname.getText().toString(),personphonenumber.getText().toString(),
                            price,image,description,name,Integer.parseInt(quantity.getText().toString()));



                    if (isInserted)
                    {
                        Toast.makeText(OrderAcitivity.this,"Order is successfully placed",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(OrderAcitivity.this," error check your Internet Connection",Toast.LENGTH_SHORT).show();
                    }


                    Intent intent=new Intent(OrderAcitivity.this,Orderplaced.class);
                    startActivity(intent);
                    finish();


                }





            }
        });











    }




}