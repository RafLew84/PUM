package pl.edu.uwr.pum.valueinjectbasicsjava.di;

import dagger.Component;
import pl.edu.uwr.pum.valueinjectbasicsjava.MainActivity;
import pl.edu.uwr.pum.valueinjectbasicsjava.di.modules.GpuModule;

@Component(modules = GpuModule.class)
public interface ComputerComponent {
    void inject(MainActivity mainActivity);
}
