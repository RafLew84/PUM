package com.example.a32_tablayoutviewpager2navigationbasics_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    public static final String arg = "key";

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new TemplateFragment();
        Bundle args = new Bundle();
        args.putInt(arg, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
