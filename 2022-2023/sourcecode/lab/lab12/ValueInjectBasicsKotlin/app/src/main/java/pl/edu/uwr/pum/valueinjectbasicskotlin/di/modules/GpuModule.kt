package pl.edu.uwr.pum.valueinjectbasicskotlin.di.modules

import dagger.Module
import dagger.Provides
import pl.edu.uwr.pum.valueinjectbasicskotlin.computer.components.GPU

@Module
class GpuModule(private val gpuCores: Int) {

    @Provides
    fun provideGpu(): GPU{
        return GPU(gpuCores)
    }
}