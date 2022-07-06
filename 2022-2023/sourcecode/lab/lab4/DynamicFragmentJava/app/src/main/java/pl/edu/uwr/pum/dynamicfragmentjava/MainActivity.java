package pl.edu.uwr.pum.dynamicfragmentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container_view_tag) != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_view_tag, new MainFragment())
                    .commit();
        }
    }
}