package pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component;

import javax.inject.Inject;

public class AMD implements CPU {

    @Inject
    public AMD() {}

    @Override
    public String name() {
        return "amd";
    }
}
