package pl.edu.uwr.pum.interfaceinjectbasicsjava.di.modules;

import dagger.Module;
import dagger.Provides;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.AMD;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.CPU;
import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.Intel;

@Module
public class IntelModule {
    @Provides
    CPU provideIntel(Intel cpu){
        return cpu;
    }
}
