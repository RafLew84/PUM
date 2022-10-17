package pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components

import javax.inject.Inject

class AMD @Inject constructor() : CPU {
    override fun name(): String {
        return "amd"
    }
}