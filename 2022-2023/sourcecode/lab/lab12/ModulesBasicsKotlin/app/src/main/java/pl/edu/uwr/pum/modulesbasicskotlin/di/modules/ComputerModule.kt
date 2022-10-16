package pl.edu.uwr.pum.modulesbasicskotlin.di.modules

import dagger.Module
import dagger.Provides
import pl.edu.uwr.pum.modulesbasicskotlin.computer.Computer
import pl.edu.uwr.pum.modulesbasicskotlin.computer.components.CPU
import pl.edu.uwr.pum.modulesbasicskotlin.computer.components.GPU

@Module
class ComputerModule {

    @Provides
    fun provideGpu(): GPU{
        return GPU()
    }

    @Provides
    fun provideCpu(): CPU{
        return CPU()
    }

    @Provides
    fun provideComputer(cpu: CPU, gpu: GPU): Computer{
        return Computer(gpu, cpu)
    }
}