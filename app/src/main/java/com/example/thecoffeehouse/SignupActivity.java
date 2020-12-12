package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignupActivity extends AppCompatActivity {
    TextView txtignore;
    ImageView back_153;
    Button btnOTP_153;
    EditText edtPhoneNumber_153;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        btnOTP_153=findViewById(R.id.btnContinue);
        edtPhoneNumber_153=findViewById(R.id.edtPhoneNumber);
        btnOTP_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtPhoneNumber_153.getText().toString().trim().isEmpty()){
                    Toast.makeText(SignupActivity.this,"Nhập số điện thoại",Toast.LENGTH_SHORT).show();
                    return;
                }
                senOTP();
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        back_153 = findViewById(R.id.back);
        back_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

    }
    public void senOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+84" + edtPhoneNumber_153.getText().toString().trim(),
                60,
                TimeUnit.SECONDS,
                SignupActivity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(SignupActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String vertificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        Intent intent= new Intent(SignupActivity.this,VerifyOtpActivity.class);
                        intent.putExtra("phone_number",edtPhoneNumber_153.getText().toString());
                        intent.putExtra("vertificationId",vertificationId);
                        startActivity(intent);
                    }
                }
        );
    }
}