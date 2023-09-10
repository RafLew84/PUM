package com.example.a52_viewpager2fragmentstateadapter_java;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerBasicAdapter extends FragmentStateAdapter {
    public PagerBasicAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new TemplateFragment(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
