package pl.edu.uwr.pum.myfinanceappjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import pl.edu.uwr.pum.myfinanceappjava.fragments.AccountsFragment;
import pl.edu.uwr.pum.myfinanceappjava.fragments.BillsFragment;
import pl.edu.uwr.pum.myfinanceappjava.fragments.OverviewFragment;
import pl.edu.uwr.pum.myfinanceappjava.util.UiSetup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FinanceAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        UiSetup.tabLayoutSetup(this, tabLayout, viewPager);
    }
}

class FinanceAdapter extends FragmentStateAdapter {

    private final Fragment[] fragments = {
            new OverviewFragment(),
            new AccountsFragment(),
            new BillsFragment()
    };

    public FinanceAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}