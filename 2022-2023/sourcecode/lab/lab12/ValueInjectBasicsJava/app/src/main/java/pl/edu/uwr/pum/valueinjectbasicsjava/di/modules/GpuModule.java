package pl.edu.uwr.pum.valueinjectbasicsjava.di.modules;

import dagger.Module;
import dagger.Provides;
import pl.edu.uwr.pum.valueinjectbasicsjava.computer.components.GPU;

@Module
public class GpuModule {

    private int gpuCores;

    public GpuModule(int gpuCores) {
        this.gpuCores = gpuCores;
    }

    @Provides
    GPU provideGpu(){
        return new GPU(gpuCores);
    }
}
