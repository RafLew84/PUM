package pl.edu.uwr.pum.wfiappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Institute> institutes = new ArrayList<>();
    private InstituteAdapter instituteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fabRefreshButton)
                .setOnClickListener(view -> {
                    initializeData();
                    instituteAdapter.notifyDataSetChanged();
                });

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,
                gridColumnCount));

        instituteAdapter = new InstituteAdapter(this, institutes);
        mRecyclerView.setAdapter(instituteAdapter);
        initializeData();
    }

    private void initializeData(){
        String[] instituteList = getResources().getStringArray(R.array.institute_titles);
        String[] instituteInfo = getResources().getStringArray(R.array.institute_info);

        TypedArray instituteImageResources = getResources()
                .obtainTypedArray(R.array.institute_images);

        institutes.clear();

        for(int i = 0; i < instituteList.length; i++)
            institutes.add(new Institute(
                            instituteList[i],
                            instituteInfo[i],
                            instituteImageResources.getResourceId(i,0))
            );

        instituteImageResources.recycle();
    }
}