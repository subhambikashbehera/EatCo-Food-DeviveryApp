package com.edusy.eatco;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edusy.eatco.Adapter.StoreBelowAdapter;
import com.edusy.eatco.DataModel.MainItemModels;
import com.edusy.eatco.authentication.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerView,RecyclerViewmain;
    TextView rname;
    FirebaseAuth mauth;
    String userID;
    ImageView myorders;
    CardView fastfood,softdrinks,snacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mauth=FirebaseAuth.getInstance();
        rname=findViewById(R.id.name);
        fastfood=findViewById(R.id.card1);
        softdrinks=findViewById(R.id.card2);
        snacks=findViewById(R.id.card3);

//        RecyclerView=findViewById(R.id.Recyclerview);
        RecyclerViewmain=findViewById(R.id.Recyclerviewmain);
        myorders=findViewById(R.id.myorders);

        userID=mauth.getCurrentUser().getUid();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Store To Door User").child(userID).child("user Info");
        ValueEventListener listener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String name=snapshot.child("name").getValue(String.class);
                rname.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        myorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Cart.class);
                startActivity(intent);


            }
        });


        fastfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Fastfood.class);
                startActivity(intent);
            }
        });

        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Snacks.class);
                startActivity(intent);
            }
        });

        softdrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Softdrinks.class);
                startActivity(intent);
            }
        });






//        ArrayList<ItemData> list=new ArrayList<>();
//
//
//        list.add(new ItemData(R.drawable.fastfood,"FASTFOOD"));
//        list.add(new ItemData(R.drawable.vegetables,"VEGETABLES"));
//        list.add(new ItemData(R.drawable.grocery,"GROCERY"));
//        list.add(new ItemData(R.drawable.fruits,"FRUITS"));
//
//        StoreAdapter adapter=new StoreAdapter(list,this);
//        RecyclerView.setAdapter(adapter);
//
//
//
////
////        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
////        RecyclerView.setLayoutManager(layoutManager);
//
////        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
////        RecyclerView.setLayoutManager(gridLayoutManager);
//
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView.setLayoutManager(layoutManager);



        ArrayList<MainItemModels> list2=new ArrayList<>();

        list2.add(new MainItemModels(R.drawable.vegburger,"Veg Burger","125","Meaty portobello mushroom makes for the perfect Vegeterian Burger"));
        list2.add(new MainItemModels(R.drawable.sprite3,"Zera drinks","40","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.b1,"Small Chips","125","Meaty portobello mushroom makes for the perfect Vegeterian Burger"));
        list2.add(new MainItemModels(R.drawable.b8,"Indian masal chips","80","fresh and newly made for you with new oil"));


        list2.add(new MainItemModels(R.drawable.chickenpokora,"Chicken pokoda","80","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.sprite4,"Coca cola","50","fresh and cold"));

        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));

        list2.add(new MainItemModels(R.drawable.chaomine,"Chowmin","50","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.sprite3,"Zera drinks","40","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.pizza,"Pizza","120","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b1,"Small Chips","125","Meaty portobello mushroom makes for the perfect Vegeterian Burger"));
        list2.add(new MainItemModels(R.drawable.b8,"Indian masal chips","80","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.sprite9,"Butter scoch","120","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite13,"pepsi","10","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sweet,"Rosogala","10","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.fishfry,"Fish FRY","80","fresh and newly made for you with new oil"));


        list2.add(new MainItemModels(R.drawable.sprite1,"Sprite can","100","fresh and cold"));
        list2.add(new MainItemModels(R.drawable.sprite2,"Spritebottle","80","fresh and cold"));

        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));

        list2.add(new MainItemModels(R.drawable.gupchup,"gupchup","10 carries 8pieces","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.paobhaji,"pao bhaji","130","fresh and newly made for you with new oil"));



        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.tomato,"Tomato","30","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.patato,"Potato","40","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.onion,"Onion","60","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.carrot,"Carrot","30","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.edibleleaves,"Foliage","20","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.bittergourd,"BitterGroud","35","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.mango,"Mango","40","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.apple,"Apple","110","fresh and home fertilized"));
        list2.add(new MainItemModels(R.drawable.banana,"Banana","65","fresh and home fertilized"));


        list2.add(new MainItemModels(R.drawable.b9,"cake","40","fresh and newly made for you with new oil"));
        list2.add(new MainItemModels(R.drawable.b10,"Mudki","50","fresh and newly made for you with new oil"));










        StoreBelowAdapter storeBelowAdapter=new StoreBelowAdapter(list2,this);
        RecyclerViewmain.setAdapter(storeBelowAdapter);


        LinearLayoutManager layoutManager2=new LinearLayoutManager(this);
        RecyclerViewmain.setLayoutManager(layoutManager2);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "please support", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.about);
                break;
            case R.id.share:
            case R.id.share2:
                Toast.makeText(this, "please share", Toast.LENGTH_SHORT).show();
                try {
                    Intent intent1 = new Intent(Intent.ACTION_SEND);
                    intent1.setType("text/plain");
                    intent1.putExtra(Intent.EXTRA_SUBJECT, "GIETU PORTAL");
                     String shareMessage="https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID+"\n\n";
                    intent1.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(intent1, "share by"));

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "error occured", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.logout:

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return true;

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Are You Sure Want to Exit ?");
        alert.setIcon(R.drawable.ic_baseline_exit_to_app_24);


        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert.create().show();

    }

}