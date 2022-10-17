package pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer

import pl.edu.uwr.pum.interfaceinjectibasicskotlin.computer.components.CPU
import javax.inject.Inject

class Computer @Inject constructor(val cpu: CPU) {
    fun cpuName(): String{
        return cpu.name()
    }
}