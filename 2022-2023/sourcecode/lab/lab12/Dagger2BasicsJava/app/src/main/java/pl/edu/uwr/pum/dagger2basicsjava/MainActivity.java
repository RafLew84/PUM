package pl.edu.uwr.pum.dagger2basicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.CPU;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.Case;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.GPU;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.Motherboard;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.PowerSupply;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Computer;
import pl.edu.uwr.pum.dagger2basicsjava.di.ComputerComponent;
import pl.edu.uwr.pum.dagger2basicsjava.di.DaggerComputerComponent;

public class MainActivity extends AppCompatActivity {

    private Computer computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComputerComponent component = DaggerComputerComponent.create();
        computer = component.getComputer();

        TextView textView = findViewById(R.id.textview);
        textView.setText(computer.work());
    }
}