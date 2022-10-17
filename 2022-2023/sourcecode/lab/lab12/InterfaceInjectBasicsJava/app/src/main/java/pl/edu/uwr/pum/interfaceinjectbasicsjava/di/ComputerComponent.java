package pl.edu.uwr.pum.interfaceinjectbasicsjava.di;

import dagger.Component;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.MainActivity;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.di.modules.AmdModule;

@Component(modules = AmdModule.class)
public interface ComputerComponent {
    void inject(MainActivity mainActivity);
}
