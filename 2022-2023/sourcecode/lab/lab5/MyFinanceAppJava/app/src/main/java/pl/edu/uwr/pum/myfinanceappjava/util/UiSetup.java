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

    public static void tabLayoutSetup(Context context, TabLayout tabLayout, ViewPager2 viewPager){
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setIcon(ContextCompat.getDrawable(context, tabIcons[position]));
                    if (position == 0){
                        tab.setText(context.getString(tabTitles[position]));
                        Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);
                    }
                }
        ).attach();

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        for (int i = 0; i < vg.getChildCount(); i++){
            if (i == tabLayout.getSelectedTabPosition())
                continue;
            View a =vg.getChildAt(i);
            a.setScaleX(tabScaleLow);
            a.setScaleY(tabScaleLow);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(context.getString(tabTitles[tab.getPosition()]));
                Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);

                View a = vg.getChildAt(tab.getPosition());
                a.animate()
                        .scaleX(tabScaleHigh)
                        .scaleY(tabScaleHigh)
                        .setInterpolator(new FastOutSlowInInterpolator())
                        .setDuration((long) context.getResources().getInteger(android.R.integer.config_mediumAnimTime))
                        .start();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText("");
                View a = vg.getChildAt(tab.getPosition());
                a.animate()
                        .scaleX(tabScaleLow)
                        .scaleY(tabScaleLow)
                        .setInterpolator(new FastOutSlowInInterpolator())
                        .setDuration(1L)
                        .start();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
