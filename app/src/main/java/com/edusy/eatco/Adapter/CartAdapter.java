package com.edusy.eatco.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edusy.eatco.DataModel.CartModel;
import com.edusy.eatco.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {

    ArrayList<CartModel> list;
    Context context;

    public CartAdapter(ArrayList<CartModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cartordersample,parent,false);
        return new CartAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final CartModel cartModel=list.get(position);
        holder.itemimage.setImageResource(cartModel.getOrderimage());
        holder.mainname.setText(cartModel.getSolditemname());
        holder.price.setText(cartModel.getSoldprice());
        holder.orderno.setText(cartModel.getOrdernumber());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView itemimage;
        TextView mainname,price,orderno;



        public viewholder(@NonNull View itemView) {
            super(itemView);

            itemimage =itemView.findViewById(R.id.cartitemimage);
            mainname=itemView.findViewById(R.id.cartmainname);
            price=itemView.findViewById(R.id.cartprice);
            orderno=itemView.findViewById(R.id.orderno);

        }
    }


}
