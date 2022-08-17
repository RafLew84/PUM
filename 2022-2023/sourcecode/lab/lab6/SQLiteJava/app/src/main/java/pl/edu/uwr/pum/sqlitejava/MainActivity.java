package pl.edu.uwr.pum.sqlitejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.Objects;

import pl.edu.uwr.pum.sqlitejava.adapter.StudentAdapter;
import pl.edu.uwr.pum.sqlitejava.databinding.ActivityMainBinding;
import pl.edu.uwr.pum.sqlitejava.db.DBHelper;
import pl.edu.uwr.pum.sqlitejava.model.Student;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DBHelper(this);

        binding.dataBaseRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        binding.dataBaseRecyclerView.setAdapter(
                new StudentAdapter(this, dbHelper)
        );

        binding.addButton.setOnClickListener(v -> {
            String name = binding.editTextName.getText().toString();
            String index = binding.editTextIndex.getText().toString();
            if (!name.isEmpty() && !index.isEmpty()) {
                dbHelper.addStudent(new Student(name, Integer.parseInt(index)));
                binding.editTextIndex.getText().clear();
                binding.editTextName.getText().clear();
            }

            Objects.requireNonNull(binding.dataBaseRecyclerView.getAdapter()).notifyItemInserted(dbHelper.getStudents().size());
        });
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}