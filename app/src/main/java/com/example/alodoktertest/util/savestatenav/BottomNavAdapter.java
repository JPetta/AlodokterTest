package com.example.alodoktertest.util.savestatenav;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class BottomNavAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragments = new ArrayList<>();

    public BottomNavAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    // custom method that populates this Adapter with Fragments
    public void addFragments(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}