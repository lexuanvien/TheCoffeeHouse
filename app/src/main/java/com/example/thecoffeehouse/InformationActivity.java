package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thecoffeehouse.gridviewadapter.SQLiteHander;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InformationActivity extends AppCompatActivity {
    EditText edEmail,edName,edbrithday;
    Button bntContinue;
    SQLiteHander db;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().hide();

        db = new SQLiteHander(getApplicationContext());
        init();

        bntContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString();
                String name = edName.getText().toString();
                String brithday = edbrithday.getText().toString();
                boolean kt = true;
                if (name.equals("")){
                    edName.setError("Vui lòng nhập name");
                    edName.requestFocus();
                    kt = false;
                }
                if (brithday.equals("")){
                    edbrithday.setError("Vui lòng nhập brithday");
                    edbrithday.requestFocus();
                    kt = false;
                }
                if (kt == true){
                    edEmail.setText("");
                    edName.setText("");
                    edbrithday.setText("");
                }
                Intent intent = new Intent(InformationActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        edbrithday.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    final DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            calendar.set(Calendar.YEAR,year);
                            calendar.set(Calendar.MONTH,month);
                            calendar.set(Calendar.DAY_OF_MONTH,day);
                            edbrithday.setText(simpleDateFormat1.format(calendar.getTime()));
                        }
                    };
                    DatePickerDialog datePickerDialog = new DatePickerDialog(InformationActivity.this,
                            callback,
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.show();
                }
            }
        });
    }

    private void init() {
        edName = (EditText) findViewById(R.id.edtName);
        edbrithday = (EditText) findViewById(R.id.edtNgaysinh);
        edEmail = (EditText) findViewById(R.id.edtEmail);
        bntContinue = (Button) findViewById(R.id.btnContinue2);
    }

}
