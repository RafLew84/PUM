package pl.edu.uwr.pum.interfaceinjectbasicsjava.computer.component;

import javax.inject.Inject;

public class Intel implements CPU {

    @Inject
    public Intel() {}

    @Override
    public String name() {
        return "intel";
    }
}
