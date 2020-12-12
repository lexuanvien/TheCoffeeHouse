package com.example.thecoffeehouse;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.gridviewadapter.TheCoffeeHouse;

import java.util.ArrayList;
import java.util.List;

public class fragment3  extends Fragment {
    View v;
    private Context context_153;
    private RecyclerView recyclerView_153;
    private List<TheCoffeeHouse> list_153;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment3_order, container, false);
        recyclerView_153 = v.findViewById(R.id.recyclerView3);
        order_fragment_adapter adapter = new order_fragment_adapter(getContext(),list_153);
        recyclerView_153.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView_153.setAdapter(adapter);
        return v;
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_153 = new ArrayList<>();
        list_153.add(new TheCoffeeHouse("Matcha Phủ Socola","45000 đ",R.drawable.matchasocola));
        list_153.add(new TheCoffeeHouse("Bông Lan Trứng Muối","29000 đ",R.drawable.bonglan));
        list_153.add(new TheCoffeeHouse("Mousse Matcha","29000 đ",R.drawable.mousse_matcha));
        list_153.add(new TheCoffeeHouse("Mousse Tiramisu","32000 đ",R.drawable.mousse_tiramisu));
        list_153.add(new TheCoffeeHouse("Mochi Kem Matcha","19000 đ",R.drawable.mochi));
        list_153.add(new TheCoffeeHouse("Mít Sấy","20000 đ",R.drawable.mitsay));
        list_153.add(new TheCoffeeHouse("Mousse Gấu Chocolate","39000 đ",R.drawable.mousse_gau));

    }
}
