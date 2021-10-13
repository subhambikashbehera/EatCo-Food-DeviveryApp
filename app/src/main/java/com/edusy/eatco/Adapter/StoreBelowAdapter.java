package com.edusy.eatco.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edusy.eatco.DataModel.MainItemModels;
import com.edusy.eatco.OrderAcitivity;
import com.edusy.eatco.R;

import java.util.ArrayList;

public class StoreBelowAdapter extends RecyclerView.Adapter<StoreBelowAdapter.viewholder> {

    ArrayList<MainItemModels> list;
    Context context;

    public StoreBelowAdapter(ArrayList<MainItemModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.itemdetailmainlayout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final  MainItemModels mainItemModels=list.get(position);
        holder.itemimage.setImageResource(mainItemModels.getPic());
        holder.mainname.setText(mainItemModels.getName());
        holder.price.setText(mainItemModels.getPrice());
        holder.description.setText(mainItemModels.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OrderAcitivity.class);
                intent.putExtra("image",mainItemModels.getPic());
                intent.putExtra("name",mainItemModels.getName());
                intent.putExtra("price",mainItemModels.getPrice());
                intent.putExtra("description",mainItemModels.getDescription());
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder {
        ImageView itemimage;
        TextView mainname,price,description;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            itemimage =itemView.findViewById(R.id.itemimage);
            mainname=itemView.findViewById(R.id.mainname);
            price=itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.Description);

        }
    }


}
