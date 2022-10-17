package pl.edu.uwr.pum.valueinjectbasicsjava.computer.components;

import javax.inject.Inject;

public class GPU {

    private int gpuCores;

    public GPU(int gpuCores) {
        this.gpuCores = gpuCores;
    }

    public int getGpuCores() {
        return gpuCores;
    }
}
