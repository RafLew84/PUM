package pl.edu.uwr.pum.dagger2basicsjava.di;

import dagger.Component;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Computer;

@Component
public interface ComputerComponent {
    Computer getComputer();
}
