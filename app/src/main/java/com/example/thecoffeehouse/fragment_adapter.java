package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class fragment_adapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList_153 = new ArrayList<>();
    private  final List<String> stringList_153 = new ArrayList<>();

    public fragment_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList_153.get(position);
    }

    @Override
    public int getCount() {
        return stringList_153.size();
    }
    public CharSequence getPageTitle(int position){
        return stringList_153.get(position);
    }
    public void AddFragment(Fragment fragment, String title) {
        fragmentList_153.add(fragment);
        stringList_153.add(title);
    }
}
