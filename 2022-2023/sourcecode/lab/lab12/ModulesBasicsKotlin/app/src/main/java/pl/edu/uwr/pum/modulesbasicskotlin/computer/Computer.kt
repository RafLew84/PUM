package pl.edu.uwr.pum.modulesbasicskotlin.computer

import pl.edu.uwr.pum.modulesbasicskotlin.computer.components.CPU
import pl.edu.uwr.pum.modulesbasicskotlin.computer.components.GPU

class Computer(val gpu: GPU, val cpu: CPU) {
    fun work():String{
        return "working"
    }
}