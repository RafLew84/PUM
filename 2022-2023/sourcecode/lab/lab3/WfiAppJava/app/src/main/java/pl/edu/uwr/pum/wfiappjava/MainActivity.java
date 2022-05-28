package pl.edu.uwr.pum.wfiappjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this,
                gridColumnCount));

        instituteAdapter = new InstituteAdapter(this, institutes);
        recyclerView.setAdapter(instituteAdapter);

        int swipeDirs;

        if(gridColumnCount >1)
            swipeDirs = 0;
        else
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                swipeDirs
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(institutes, from, to);
                instituteAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                institutes.remove(viewHolder.getAdapterPosition());
                instituteAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(recyclerView);

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