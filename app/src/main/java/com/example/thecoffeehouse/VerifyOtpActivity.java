package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class VerifyOtpActivity extends AppCompatActivity {
    EditText edt_OTP_153;
    TextView txt_sdt_153;
    Button btn_otp_153;
    String otp_153;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        getSupportActionBar().hide();
        edt_OTP_153=findViewById(R.id.edt_OTP);
        mAuth=FirebaseAuth.getInstance();
        txt_sdt_153=findViewById(R.id.txt_phoneNub);
        txt_sdt_153.setText(getIntent().getStringExtra("phone_number"));
        otp_153=getIntent().getStringExtra("vertificationId");
        btn_otp_153=findViewById(R.id.btn_Verify);
        btn_otp_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_OTP_153.getText().toString().isEmpty()) {
                    Toast.makeText(VerifyOtpActivity.this,"Nhập mã OTP",Toast.LENGTH_SHORT).show();
                }else if (edt_OTP_153.getText().toString().trim().length()!=6)
                    Toast.makeText(VerifyOtpActivity.this,"Mã OTP không đúng",Toast.LENGTH_SHORT).show();
                else {
                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp_153,edt_OTP_153.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (mAuth!=null) {
                            Intent intent= new Intent(VerifyOtpActivity.this,InformationActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"Đăng Nhập sai",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
}