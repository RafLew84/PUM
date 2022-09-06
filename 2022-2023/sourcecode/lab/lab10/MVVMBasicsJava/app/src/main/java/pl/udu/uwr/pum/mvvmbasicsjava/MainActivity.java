package pl.udu.uwr.pum.mvvmbasicsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        myViewModel.getMyData().observe(this, s -> textView.setText(s));

        // button.setOnClickListener(v -> myViewModel.myData.setValue("zmiana"));
    }
}