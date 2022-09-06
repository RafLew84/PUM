package pl.udu.uwr.pum.mvpbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyView {

    private TextView textView;
    private Button button;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        presenter = new Presenter(this);

        button.setOnClickListener(v -> presenter.getDetails());
    }

    @Override
    public void onDisplay(String text) {
        textView.setText(text);
    }
}