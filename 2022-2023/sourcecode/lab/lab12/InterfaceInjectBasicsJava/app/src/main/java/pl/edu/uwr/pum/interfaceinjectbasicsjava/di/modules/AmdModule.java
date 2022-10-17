package pl.edu.uwr.pum.interfaceinjectbasicsjava.di.modules;

import dagger.Binds;
import dagger.Module;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.AMD;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.CPU;

@Module
abstract public class AmdModule {
    @Binds
    abstract CPU provideCpu(AMD cpu);
}
