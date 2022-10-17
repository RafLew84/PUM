package pl.edu.uwr.pum.interfaceinjectibasicskotlin.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components.AMD
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components.CPU

@Module
abstract class AmdModule {
    @Binds
    abstract fun bindCpu(cpu: AMD): CPU
}