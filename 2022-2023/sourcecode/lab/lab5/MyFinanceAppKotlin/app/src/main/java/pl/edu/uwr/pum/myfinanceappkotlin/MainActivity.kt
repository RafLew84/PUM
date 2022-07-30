package pl.edu.uwr.pum.myfinanceappkotlin

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import pl.edu.uwr.pum.myfinanceappkotlin.adapters.FinanceAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.util.tabLayoutSetup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.apply {
            adapter = FinanceAdapter(this@MainActivity)
        }

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayoutSetup(this, tabLayout, viewPager2)
    }
}