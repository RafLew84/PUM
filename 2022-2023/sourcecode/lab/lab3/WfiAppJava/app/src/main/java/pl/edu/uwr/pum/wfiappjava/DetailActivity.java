package pl.edu.uwr.pum.wfiappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView instituteTitle = findViewById(R.id.titleDetail);
        ImageView instituteImage = findViewById(R.id.instituteImageDetail);

        Institute institute = getIntent().getParcelableExtra(InstituteAdapter.INSTITUTE_EXTRA);

        if(institute != null) {
            instituteTitle.setText(institute.getTitle());

            Glide.with(this)
                    .load(institute.getImageResource())
                    .into(instituteImage);
        }
    }
}