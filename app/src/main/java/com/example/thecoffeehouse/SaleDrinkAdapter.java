package com.example.thecoffeehouse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SaleDrinkAdapter extends RecyclerView.Adapter<SaleDrinkAdapter.SaleDrinkViewHolder> {
    Context context;
    List<SaleDrink> saleDrinks;

    public SaleDrinkAdapter(Context context, List<SaleDrink> saleDrinks) {
        this.context = context;
        this.saleDrinks = saleDrinks;
    }

    @NonNull
    @Override
    public SaleDrinkAdapter.SaleDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_sale_row_item, parent, false);
        return new SaleDrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleDrinkAdapter.SaleDrinkViewHolder holder, int position) {
        holder.drinkImage.setImageResource(saleDrinks.get(position).getImageUrl());
        holder.name.setText(saleDrinks.get(position).getName());
        holder.location.setText(saleDrinks.get(position).getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, HomeActivity.class);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return saleDrinks.size();
    }

    public class SaleDrinkViewHolder extends RecyclerView.ViewHolder {
        ImageView drinkImage;
        TextView name, location;
        public SaleDrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            drinkImage = itemView.findViewById(R.id.drink_image);
            location = itemView.findViewById(R.id.location_name);
            name = itemView.findViewById(R.id.drink_name);
        }
    }
}
