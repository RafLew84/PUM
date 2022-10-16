package pl.edu.uwr.pum.modulesbasicsjava.di.modules;

import dagger.Module;
import dagger.Provides;
import pl.edu.uwr.pum.modulesbasicsjava.computer.Computer;
import pl.edu.uwr.pum.modulesbasicsjava.computer.components.CPU;
import pl.edu.uwr.pum.modulesbasicsjava.computer.components.GPU;

@Module
public class ComputerModule {
    @Provides
    static GPU provideGpu(){
        return new GPU();
    }

    @Provides
    static CPU provideCpu(){
        return new CPU();
    }

    @Provides
    static Computer provideComputer(GPU gpu, CPU cpu){
        return new Computer(gpu, cpu);
    }
}
