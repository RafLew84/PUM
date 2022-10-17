package pl.edu.uwr.pum.interfaceinjectbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.Computer;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.di.ComputerComponent;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.di.DaggerComputerComponent;

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
        textView.setText(computer.cpuName());
    }
}