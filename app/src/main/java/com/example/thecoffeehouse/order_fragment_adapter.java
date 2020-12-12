package com.example.thecoffeehouse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.gridviewadapter.TheCoffeeHouse;

import java.util.ArrayList;
import java.util.List;

public class order_fragment_adapter extends RecyclerView.Adapter<order_fragment_adapter.Order_ViewHolder> {
    Context context;
    List<TheCoffeeHouse> theCoffeeHouses;

    public order_fragment_adapter(Context context, List<TheCoffeeHouse> theCoffeeHouses) {
        this.context = context;
        this.theCoffeeHouses = theCoffeeHouses;
    }

    @NonNull
    @Override
    public Order_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_order_item, parent, false);
        return new  order_fragment_adapter.Order_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order_ViewHolder holder, int position) {
        holder.imgOrder.setImageResource(theCoffeeHouses.get(position).getImage());
        holder.txtOrder.setText(theCoffeeHouses.get(position).getTitle());
        holder.txtPrice.setText(theCoffeeHouses.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theCoffeeHouses.size();
    }

    public static final class Order_ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgOrder;
        TextView txtOrder, txtPrice;
        public Order_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOrder = itemView.findViewById(R.id.img_Oder);
            txtOrder = itemView.findViewById(R.id.txt_Order);
            txtPrice = itemView.findViewById(R.id.price);
        }
    }

}
