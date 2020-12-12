package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StoreActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int MY_REQUEST_INT = 177;
    private GoogleMap mMap_153;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        bottomnav();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap_153 = googleMap;

        //Enable Current Location

        //Lấy GPS
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION},MY_REQUEST_INT);
            }

            return;
        }else{
            mMap_153.setMyLocationEnabled(true);
        }

        // Add a marker in Sydney and move the camera
        LatLng university = new LatLng(116.078136501191835, 108.21246501421244);
        mMap_153.addMarker(new MarkerOptions().position(university).title("Trường đại học Sư phạm kỹ thuật Đà Nẵng"));
        mMap_153.moveCamera(CameraUpdateFactory.newLatLng(university));

        LatLng coffee1 = new LatLng(16.072774, 108.220897);
        mMap_153.addMarker(new MarkerOptions().position(coffee1).title("The Coffee House Nguyễn Chí Thanh"));
        mMap_153.moveCamera(CameraUpdateFactory.newLatLng(coffee1));

        LatLng coffee2 = new LatLng(16.067070461341476, 108.20783975097503);
        mMap_153.addMarker(new MarkerOptions().position(coffee2).title("The Coffee House Lê Duẩn"));
        mMap_153.moveCamera(CameraUpdateFactory.newLatLng(coffee2));

        LatLng coffee3 = new LatLng(16.067306456662223, 108.21586676005094);
        mMap_153.addMarker(new MarkerOptions().position(coffee3).title("The Coffee House Triệu Nữ Vương"));
        mMap_153.moveCamera(CameraUpdateFactory.newLatLng(coffee3));

        LatLng coffee4 = new LatLng(16.054682199424274, 108.2207569656095);
        mMap_153.addMarker(new MarkerOptions().position(coffee4).title("The Coffee House Núi Thành"));

        LatLng coffee5 = new LatLng(16.06075555854913, 108.22202228635764);
        mMap_153.addMarker(new MarkerOptions().position(coffee5).title("The Coffee House Nguyễn Văn Linh"));

        LatLng coffee6 = new LatLng(16.08593049001257, 108.22051477053938);
        mMap_153.addMarker(new MarkerOptions().position(coffee6).title("The Coffee House 3/2"));

        LatLng coffee7 = new LatLng(16.069824743695076, 108.21737617124745);
        mMap_153.addMarker(new MarkerOptions().position(coffee7).title("The Coffee House Ngô Gia Tự"));

        LatLng coffee8 = new LatLng(16.064598181374777, 108.23021785888209);
        mMap_153.addMarker(new MarkerOptions().position(coffee8).title("The Coffee House Trần Hưng Đạo"));

        LatLng coffee9 = new LatLng(16.04256217067753, 108.24560848323377);
        mMap_153.addMarker(new MarkerOptions().position(coffee9).title("The Coffee House Nguyễn Văn Thoại"));

    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.store);
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
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                }
                return false;
            }
        });
    }
}