package pl.edu.uwr.pum.viewpagerfragmentstateadapterjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final int num = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        PagerAdapter adapter = new PagerAdapter(this);
        viewPager2.setAdapter(adapter);
    }
}