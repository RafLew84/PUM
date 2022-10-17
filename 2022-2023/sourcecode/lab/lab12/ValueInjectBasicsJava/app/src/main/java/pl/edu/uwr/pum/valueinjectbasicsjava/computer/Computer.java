package pl.edu.uwr.pum.valueinjectbasicsjava.computer;

import javax.inject.Inject;

import pl.edu.uwr.pum.valueinjectbasicsjava.computer.components.GPU;

public class Computer {

    private GPU gpu;

    @Inject
    public Computer(GPU gpu) {
        this.gpu = gpu;
    }

    public String getGpuCores(){
        return String.valueOf(gpu.getGpuCores());
    }
}
