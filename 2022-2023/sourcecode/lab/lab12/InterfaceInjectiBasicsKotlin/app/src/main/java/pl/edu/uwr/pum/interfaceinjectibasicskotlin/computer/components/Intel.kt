package pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components

import javax.inject.Inject

class Intel @Inject constructor() : CPU {
    override fun name(): String {
        return "intel"
    }
}