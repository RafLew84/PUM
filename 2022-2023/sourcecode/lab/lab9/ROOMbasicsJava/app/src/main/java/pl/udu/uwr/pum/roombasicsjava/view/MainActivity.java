package pl.udu.uwr.pum.roombasicsjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pl.udu.uwr.pum.roombasicsjava.R;
import pl.udu.uwr.pum.roombasicsjava.model.Word;
import pl.udu.uwr.pum.roombasicsjava.viewmodel.WordViewModel;

public class MainActivity extends AppCompatActivity {

    private WordViewModel wordViewModel;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(new WordsComparator());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wordViewModel.getAllWords().observe(this, adapter::submitList);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
                        wordViewModel.insert(new Word("word " + num));
                        num++;
                    });
    }


}