package pl.edu.uwr.pum.recyclerviewselectorjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        NumberListAdapter numberListAdapter = new NumberListAdapter(createList());
        recyclerView.setAdapter(numberListAdapter);
        SelectionTracker<Long> selectionTracker = new SelectionTracker.Builder<>(
                "numberSelection",
                recyclerView,
                new StableIdKeyProvider(recyclerView),
                new NumberItemDetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
        ).build();
        numberListAdapter.setSelectionTracker(selectionTracker);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private LinkedList<Integer> createList(){
        LinkedList<Integer> numbers = new LinkedList<>();

        for(int i = 0; i < 50; i++)
            numbers.add(i);

        return  numbers;
    }
}