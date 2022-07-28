package pl.edu.uwr.pum.viewpagerrecyclerviewadapterkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ViewPager2>(R.id.viewPager).apply {
            adapter = PagerAdapter()
        }
    }

    companion object{
        val values = listOf("pierwszy", "drugi", "trzeci")
    }
}