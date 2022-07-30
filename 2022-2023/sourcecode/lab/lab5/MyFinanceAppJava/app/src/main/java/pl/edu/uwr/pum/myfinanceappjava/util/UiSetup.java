package pl.edu.uwr.pum.myfinanceappjava.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import pl.edu.uwr.pum.myfinanceappjava.R;

public final class UiSetup {

    private UiSetup(){}

    private static final float tabScaleLow = 0.7f;
    private static final float tabScaleHigh = 1f;

    private static final int[] tabTitles = {R.string.overview, R.string.accounts, R.string.bills};
    private static final int[] tabIcons = {R.drawable.ic_overview, R.drawable.ic_accounts, R.drawable.ic_bills};

    public static void tabLayoutSetup(Context context, TabLayout tabLayout, ViewPager2 viewPager) {
        setupTabMediator(context, tabLayout, viewPager);
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        initialTabsSetup(tabLayout, vg);
        setupTabSelection(context, tabLayout, vg);
    }

    private static void setupTabSelection(Context context, TabLayout tabLayout, ViewGroup vg) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(context.getString(tabTitles[tab.getPosition()]));
                Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);
                
                setupAnimation(vg.getChildAt(tab.getPosition()), tabScaleHigh,
                        (long) context.getResources().getInteger(android.R.integer.config_mediumAnimTime));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText("");
                setupAnimation(vg.getChildAt(tab.getPosition()), tabScaleLow, 1L);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private static void setupAnimation(View view, float scale, long duration) {
        view.animate()
                .scaleX(scale)
                .scaleY(scale)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(duration)
                .start();
    }

    private static void initialTabsSetup(TabLayout tabLayout, ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            if (i == tabLayout.getSelectedTabPosition())
                continue;
            View a = vg.getChildAt(i);
            a.setScaleX(tabScaleLow);
            a.setScaleY(tabScaleLow);
        }
    }

    private static void setupTabMediator(Context context, TabLayout tabLayout, ViewPager2 viewPager ){
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setIcon(ContextCompat.getDrawable(context, tabIcons[position]));
                    if (position == 0) {
                        tab.setText(context.getString(tabTitles[position]));
                        Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);
                    }
                }
        ).attach();
    }
}
