package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    LinearLayout infoprofile_153;
    LinearLayout order_153;
    SaleDrinkAdapter saleDrinkAdapter_153;
    RecyclerView saleDrinkCycle_153;
    RecyclerView CoffeeHouseCycle_153;
    RecyclerView CoffeeLoverCycle_153;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        bottomnav();
        hotdrinkAdd();
        CoffeeHouse();
        CoffeeLover();

        order_153 = findViewById(R.id.dathang);
        order_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        infoprofile_153 = findViewById(R.id.info_home);
        infoprofile_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, InformationProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.order:
                        startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.store:
                        startActivity(new Intent(getApplicationContext(), StoreActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
    private void hotdrinkAdd() {
        List<SaleDrink> saleDrinks = new ArrayList<>();
        saleDrinks.add(new SaleDrink("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r1));
        saleDrinks.add(new SaleDrink("Nhà mời cà phê đậm đà hương vị, chỉ 12k!!", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r2));
        saleDrinks.add(new SaleDrink("Nhà mời 20% PICKUP nha, nhanh tay nào", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r3));
        saleDrinks.add(new SaleDrink("Bánh ngon Nhà mời, chỉ 19.000đ! Mại zô", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r4));
        saleDrinks.add(new SaleDrink("Mua 3 tặng 1 - Mời nhóm mình chung vui", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r5));
        saleDrinks.add(new SaleDrink("Team Hà Nội gọi combo trà, tặng ngay ly xịn xò", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r6));
        setSaleRecycler(saleDrinks);
    }

    private void setSaleRecycler(List<SaleDrink> saleDrinks) {
        saleDrinkCycle_153 = findViewById(R.id.hot_sale_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        saleDrinkCycle_153.setLayoutManager(layoutManager);
        saleDrinkAdapter_153 = new SaleDrinkAdapter(this, saleDrinks);
        saleDrinkCycle_153.setAdapter(saleDrinkAdapter_153);
    }

    private void CoffeeHouse() {
        List<SaleDrink> saleDrinks = new ArrayList<>();
        saleDrinks.add(new SaleDrink("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r1));
        saleDrinks.add(new SaleDrink("Nhà mời cà phê đậm đà hương vị, chỉ 12k!!", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r2));
        saleDrinks.add(new SaleDrink("Nhà mời 20% PICKUP nha, nhanh tay nào", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r3));
        saleDrinks.add(new SaleDrink("Bánh ngon Nhà mời, chỉ 19.000đ! Mại zô", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r4));
        saleDrinks.add(new SaleDrink("Mua 3 tặng 1 - Mời nhóm mình chung vui", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r5));
        saleDrinks.add(new SaleDrink("Team Hà Nội gọi combo trà, tặng ngay ly xịn xò", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r6));
        setCoffeeHouseRecycler(saleDrinks);
    }

    private void setCoffeeHouseRecycler(List<SaleDrink> saleDrinks) {
        CoffeeHouseCycle_153 = findViewById(R.id.Coffee_House_Recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        CoffeeHouseCycle_153.setLayoutManager(layoutManager);
        saleDrinkAdapter_153 = new SaleDrinkAdapter(this, saleDrinks);
        CoffeeHouseCycle_153.setAdapter(saleDrinkAdapter_153);
    }

    private void CoffeeLover() {
        List<SaleDrink> saleDrinks = new ArrayList<>();
        saleDrinks.add(new SaleDrink("Giảm 50%, thèm gì gọi nhé Nhà mang tới liền", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r1));
        saleDrinks.add(new SaleDrink("Nhà mời cà phê đậm đà hương vị, chỉ 12k!!", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r2));
        saleDrinks.add(new SaleDrink("Nhà mời 20% PICKUP nha, nhanh tay nào", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r3));
        saleDrinks.add(new SaleDrink("Bánh ngon Nhà mời, chỉ 19.000đ! Mại zô", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r4));
        saleDrinks.add(new SaleDrink("Mua 3 tặng 1 - Mời nhóm mình chung vui", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r5));
        saleDrinks.add(new SaleDrink("Team Hà Nội gọi combo trà, tặng ngay ly xịn xò", "Hòa vào không khí siêu sale cuối năm, nhanh tay gọi cho minmhf món yêu thích nhé!!!", R.drawable.r6));
        setCoffeeLoverRecycler(saleDrinks);
    }

    private void setCoffeeLoverRecycler(List<SaleDrink> saleDrinks) {
        CoffeeHouseCycle_153 = findViewById(R.id.Coffee_Lover_Recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        CoffeeHouseCycle_153.setLayoutManager(layoutManager);
        saleDrinkAdapter_153 = new SaleDrinkAdapter(this, saleDrinks);
        CoffeeHouseCycle_153.setAdapter(saleDrinkAdapter_153);
    }
}