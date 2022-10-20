package pl.edu.uwr.pum.dagger_hilt_room_basicsjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import dagger.hilt.android.AndroidEntryPoint;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.R;
import pl.edu.uwr.pum.dagger_hilt_room_basicsjava.data.Student;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private AppViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);

        viewModel = new ViewModelProvider(this).get(AppViewModel.class);

        viewModel.insert(new Student(0, "Rafa"));
        viewModel.insert(new Student(0, "Maciej"));
        viewModel.insert(new Student(0, "Kuba"));

        viewModel.readAllData().observe(this, students ->{
            StringBuilder content = new StringBuilder();
            students.forEach(student -> content
                    .append("id: ").append(student.getId()).append("\n")
                    .append("Name: ").append(student.getName()).append("\n\n"));
            textView.setText(content.toString());
        });
    }
}