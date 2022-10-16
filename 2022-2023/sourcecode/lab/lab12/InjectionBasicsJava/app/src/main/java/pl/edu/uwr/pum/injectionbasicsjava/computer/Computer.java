package pl.edu.uwr.pum.injectionbasicsjava.computer;

import javax.inject.Inject;

import pl.edu.uwr.pum.injectionbasicsjava.computer.components.CPU;
import pl.edu.uwr.pum.injectionbasicsjava.computer.components.Case;
import pl.edu.uwr.pum.injectionbasicsjava.computer.components.GPU;
import pl.edu.uwr.pum.injectionbasicsjava.computer.components.Monitor;
import pl.edu.uwr.pum.injectionbasicsjava.computer.components.Motherboard;
import pl.edu.uwr.pum.injectionbasicsjava.computer.components.PowerSupply;


public class Computer {
    private Case computerCase;
    private GPU gpu;
    private CPU cpu;
    private Motherboard motherboard;
    private PowerSupply powerSupply;

    public String text;

    @Inject
    public Computer(
            Case computerCase,
            CPU cpu,
            GPU gpu,
            Motherboard motherboard,
            PowerSupply powerSupply){
        this.computerCase = computerCase;
        this.cpu = cpu;
        this.gpu = gpu;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
    }

    public String work(){
        return "working";
    }

    @Inject
    public void monitor(Monitor monitor){
        text = monitor.setComputer(this);
    }
}
