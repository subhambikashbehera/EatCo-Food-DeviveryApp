package com.edusy.eatco.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edusy.eatco.DataModel.ItemData;
import com.edusy.eatco.R;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.Viewholder>{

    ArrayList<ItemData> list;
    Context context;

    public StoreAdapter(ArrayList<ItemData> list, Context context) {
        this.list = list;
        this.context = context;

    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerviewofmainitem,parent,false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ItemData model=list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.itemimage);
            textView=itemView.findViewById(R.id.textView3);


        }
    }
}
