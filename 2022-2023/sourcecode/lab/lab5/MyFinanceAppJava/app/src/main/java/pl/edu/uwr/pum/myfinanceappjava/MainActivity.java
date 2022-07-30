package pl.edu.uwr.pum.myfinanceappjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import pl.edu.uwr.pum.myfinanceappjava.adapters.FinanceAdapter;
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