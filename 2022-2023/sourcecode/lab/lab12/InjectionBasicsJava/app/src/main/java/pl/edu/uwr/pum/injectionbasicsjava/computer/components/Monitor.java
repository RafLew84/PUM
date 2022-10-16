package pl.edu.uwr.pum.injectionbasicsjava.computer.components;

import javax.inject.Inject;

import pl.edu.uwr.pum.injectionbasicsjava.computer.Computer;

public class Monitor {
    @Inject
    public Monitor() {
    }

    public String setComputer(Computer computer){
        return "monitor connected";
    }
}
