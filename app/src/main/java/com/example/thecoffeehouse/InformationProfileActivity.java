package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class InformationProfileActivity extends AppCompatActivity {
    TextView viewname,viewemail,viewbirthday;
    ImageView btnback_153;
    TextView txtChange_153;
    EditText edtName_153, edtBOD_153, edtEmail_153;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_profile);
        getSupportActionBar().hide();

        init();
        Getinfomation();

        btnback_153 = findViewById(R.id.backProfile);
        btnback_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        txtChange_153 = findViewById(R.id.change);
        txtChange_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, UpdateInfoActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Getinfomation() {
        Information sinhVien = (Information) getIntent().getSerializableExtra("thongtin");
        viewname.setText("Name : "+sinhVien.getName());
        viewemail.setText("Email : "+sinhVien.getEmail());
        viewbirthday.setText("Brithday : "+sinhVien.getBirhday());
    }

    private void init() {
        viewname = (TextView) findViewById(R.id.txtName);
        viewemail = (TextView) findViewById(R.id.txt_Email);
        viewbirthday = (TextView) findViewById(R.id.txtBOD);
    }
}