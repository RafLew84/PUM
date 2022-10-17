package pl.edu.uwr.pum.interfaceinjectibasicskotlin.di.modules

import dagger.Module
import dagger.Provides
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components.CPU
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components.Intel

@Module
class IntelModule {
    @Provides
    fun provideCpu(cpu: Intel): CPU {
        return cpu
    }
}