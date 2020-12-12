package com.example.thecoffeehouse;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thecoffeehouse.gridviewadapter.TheCoffeeHouse;

import java.util.ArrayList;
import java.util.List;

public class fragment1_oder extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1_oder);
        getSupportActionBar().hide();

    }
}