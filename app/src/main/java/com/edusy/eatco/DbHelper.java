package com.edusy.eatco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.edusy.eatco.DataModel.CartModel;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

   final static String DBNAME="mydatabase.db";
   final static int DBVERSION=3;


    public DbHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(


                "create table orders" +
                        "( id integer primary key autoincrement,"+
                        "name text,"+
                        "phone text,"+
                        "price int,"+
                        "quantity int,"+
                        "image int,"+
                        "description text,"+
                        "itemname text)"

        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orders");
        onCreate(db);


    }

    public boolean insertOrder(String name,String phone,int price,int image,String desc,String ordername,int quantity)
    {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("itemname",ordername);
        values.put("quantity",quantity);

      long id=sqLiteDatabase.insert("orders",null,values);
      if (id <=0)
      {
          return false;
      }else
      {
          return true;
      }

    }


    public ArrayList<CartModel> getorders()
    {
        ArrayList<CartModel> orders =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from orders",null);
        if (cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                CartModel cartModel=new CartModel();
                cartModel.setOrdernumber(cursor.getInt(0)+"");
                cartModel.setSolditemname(cursor.getString(1));
                cartModel.setSoldprice(cursor.getInt(3)+"");
                cartModel.setOrderimage(cursor.getInt(5));
                orders.add(cartModel);
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return orders;
    }


}
