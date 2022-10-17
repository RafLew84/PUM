package pl.edu.uwr.pum.valueinjectbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.uwr.pum.valueinjectbasicsjava.computer.Computer;
import pl.edu.uwr.pum.valueinjectbasicsjava.di.ComputerComponent;
import pl.edu.uwr.pum.valueinjectbasicsjava.di.DaggerComputerComponent;
import pl.edu.uwr.pum.valueinjectbasicsjava.di.modules.GpuModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Computer computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComputerComponent component = DaggerComputerComponent.builder()
                .gpuModule(new GpuModule(8))
                .build();

        component.inject(this);
        TextView textView = findViewById(R.id.textview);
        textView.setText(computer.getGpuCores());
    }
}