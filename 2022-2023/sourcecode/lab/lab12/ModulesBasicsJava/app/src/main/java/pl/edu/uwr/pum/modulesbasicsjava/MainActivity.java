package pl.edu.uwr.pum.modulesbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.uwr.pum.modulesbasicsjava.computer.Computer;
import pl.edu.uwr.pum.modulesbasicsjava.di.ComputerComponent;
import pl.edu.uwr.pum.modulesbasicsjava.di.DaggerComputerComponent;

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
        textView.setText(computer.work());
    }
}