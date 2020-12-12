package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    Button btnLogout_153;
    RelativeLayout MyProfile_153;
    ListView listView_153;
    String mTitle[] ={"The Coffee House ReWards", "Thông tin tài khoản", "Nhạc đang phát", "Lịch sử", "Giúp đỡ", "Cài đặt"};
    int images [] = {R.drawable.reward,R.drawable.userpr, R.drawable.listmusic, R.drawable.history, R.drawable.warning, R.drawable.settings};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        bottomnav();

        MyProfile_153 = findViewById(R.id.profile);
        MyProfile_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfileActivity.this, InformationProfileActivity.class);
                startActivity(intent);
            }
        });

        btnLogout_153 = findViewById(R.id.btnLogout);
        btnLogout_153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        listView_153 = findViewById(R.id.lvPF);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView_153.setAdapter(adapter);

        listView_153.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    //Intent intent = new Intent(getApplicationContext(), VoucherActivity.class);
                    //startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(getApplicationContext(), InformationProfileActivity.class);
                    startActivity(intent);
                }
                if (position ==  2) {
                    //Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
                    //startActivity(intent);
                }
                if (position ==  3) {
                   // Intent intent = new Intent(getApplicationContext(), InviteFriendsActivity.class);
                   // startActivity(intent);
                }
                if (position ==  4) {
                    // intent = new Intent(getApplicationContext(), HelpCenterActivity.class);
                   // startActivity(intent);
                }
                if (position ==  5) {
                    //Intent intent = new Intent(getApplicationContext(), RegulationsActivity.class);
                    //startActivity(intent);
                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[], int imgs[]) {
            super(c, R.layout.row, R.id.TextView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.TextView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                    case R.id.order:
                        startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.store:
                        startActivity(new Intent(getApplicationContext(), StoreActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });
    }
}