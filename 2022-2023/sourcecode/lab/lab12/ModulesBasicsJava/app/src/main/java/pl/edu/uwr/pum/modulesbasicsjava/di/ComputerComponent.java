package pl.edu.uwr.pum.modulesbasicsjava.di;

import dagger.Component;
import pl.edu.uwr.pum.modulesbasicsjava.MainActivity;
import pl.edu.uwr.pum.modulesbasicsjava.di.modules.ComputerModule;

@Component(modules = ComputerModule.class)
public interface ComputerComponent {
    void inject(MainActivity mainActivity);
}
