package pl.edu.uwr.pum.injectionbasicsjava.di;

import dagger.Component;
import pl.edu.uwr.pum.injectionbasicsjava.MainActivity;

@Component
public interface ComputerComponent {
    void inject(MainActivity mainActivity);
}
