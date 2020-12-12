package com.example.thecoffeehouse;

import android.content.ClipData;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import com.example.thecoffeehouse.gridviewadapter.TheCoffeeHouse;

import java.util.ArrayList;
import java.util.List;

public class fragment1 extends Fragment {
    View v;
    private RecyclerView recyclerView_153;
    private List<TheCoffeeHouse> list_153;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment1_oder, container, false);
        recyclerView_153 = v.findViewById(R.id.recyclerView1);
        order_fragment_adapter adapter = new order_fragment_adapter(getContext(),list_153);
        recyclerView_153.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView_153.setAdapter(adapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_153 = new ArrayList<>();
        list_153.add(new TheCoffeeHouse("Cà Phê Sữa Đá","32000 đ",R.drawable.cafesua));
        list_153.add(new TheCoffeeHouse("Bạc Xỉu","32000 đ",R.drawable.bacxiu));
        list_153.add(new TheCoffeeHouse("Cà Phê Đá Xay-Lạnh","59000 đ",R.drawable.cafedaxay));
        list_153.add(new TheCoffeeHouse("Latte Đá","50000 đ",R.drawable.latte));
        list_153.add(new TheCoffeeHouse("Cold Brew Truyền Thống","45000 đ",R.drawable.amricano));
        list_153.add(new TheCoffeeHouse("Cold Brew Sữa Tươi","45000 đ",R.drawable.coldbrew));
        list_153.add(new TheCoffeeHouse("Americano Đá","40000đ ",R.drawable.amricano));
        list_153.add(new TheCoffeeHouse("Cappucino Nóng","50000 đ",R.drawable.cappucino_nong));
        list_153.add(new TheCoffeeHouse("Cappucino Đá","50000 đ ",R.drawable.mocha));
        list_153.add(new TheCoffeeHouse("Latte Nóng","50000 đ ",R.drawable.latte));
        list_153.add(new TheCoffeeHouse("Cà Phê Đen Đá","32000 đ ",R.drawable.cafeden));
        list_153.add(new TheCoffeeHouse("Cold Brew Phúc Bồn Tử","50000 đ ",R.drawable.coldbrewpbt));
        list_153.add(new TheCoffeeHouse("Cold Brew Cam Sả","50000 đ ",R.drawable.coldbrewcamsa));
        list_153.add(new TheCoffeeHouse("Phúc Bồn Tử Cam Đá Xay","59000 đ ",R.drawable.pbtdaxay));
        list_153.add(new TheCoffeeHouse("Cà Phê Đá Xay-Lạnh","59000 đ ",R.drawable.cafedaxay));
        list_153.add(new TheCoffeeHouse("Chocolate Đá Xay","59000 đ ",R.drawable.chocolatedaxay));
        list_153.add(new TheCoffeeHouse("Matcha Đá Xay","59000 đ ",R.drawable.matchadaxay));
        list_153.add(new TheCoffeeHouse("Chanh Xả Đá Xay","49000 đ ",R.drawable.chanhxa));
    }
}
