package pl.edu.uwr.pum.wfiappkotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val institute = intent.getParcelableExtra<Institute>(INSTITUTE_EXTRA)

        if (institute != null){
            findViewById<TextView>(R.id.titleDetail).text = institute.title
            Glide.with(this)
                .load(institute.imageResource)
                .into(findViewById(R.id.instituteImageDetail))
            findViewById<ImageView>(R.id.instituteImageDetail)
        }
    }
}