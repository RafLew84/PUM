package pl.edu.uwr.pum.interfaceinjectbasicsjava.computer;

import javax.inject.Inject;

import pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component.CPU;

public class Computer {
    private CPU cpu;

    @Inject
    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

    public String cpuName(){
        return cpu.name();
    }
}
