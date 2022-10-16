package pl.edu.uwr.pum.modulesbasicsjava.computer;

import pl.edu.uwr.pum.modulesbasicsjava.computer.components.CPU;
import pl.edu.uwr.pum.modulesbasicsjava.computer.components.GPU;

public class Computer {
    private GPU gpu;
    private CPU cpu;

    public Computer(GPU gpu, CPU cpu) {
        this.gpu = gpu;
        this.cpu = cpu;
    }

    public String work(){
        return "working";
    }
}
