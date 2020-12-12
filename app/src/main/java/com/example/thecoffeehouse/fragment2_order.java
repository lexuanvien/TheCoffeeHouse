package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class fragment2_order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2_order);
        getSupportActionBar().hide();
    }
}