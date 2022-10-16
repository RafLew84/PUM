package pl.edu.uwr.pum.injectionbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.uwr.pum.injectionbasicsjava.computer.Computer;
import pl.edu.uwr.pum.injectionbasicsjava.di.ComputerComponent;
import pl.edu.uwr.pum.injectionbasicsjava.di.DaggerComputerComponent;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Computer computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComputerComponent component = DaggerComputerComponent.create();
        component.inject(this);
        TextView textView = findViewById(R.id.textview);
        textView.setText(computer.work() + computer.text);
    }
}