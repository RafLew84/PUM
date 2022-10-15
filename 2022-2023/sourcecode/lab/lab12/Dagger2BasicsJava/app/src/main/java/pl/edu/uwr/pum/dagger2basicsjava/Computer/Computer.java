package pl.edu.uwr.pum.dagger2basicsjava.Computer;

import javax.inject.Inject;

import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.CPU;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.Case;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.GPU;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.Motherboard;
import pl.edu.uwr.pum.dagger2basicsjava.Computer.Components.PowerSupply;

public class Computer {
    private Case computerCase;
    private GPU gpu;
    private CPU cpu;
    private Motherboard motherboard;
    private PowerSupply powerSupply;

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
}
