package pl.edu.uwr.pum.dynamicfragmentkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<FragmentContainerView>(R.id.fragment_container_view_tag) != null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view_tag, MainFragment())
                .commit()
        }
    }
}