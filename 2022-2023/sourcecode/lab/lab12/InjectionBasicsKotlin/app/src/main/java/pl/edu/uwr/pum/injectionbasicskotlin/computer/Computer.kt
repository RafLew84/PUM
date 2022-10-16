package pl.edu.uwr.pum.injectionbasicskotlin.computer

import pl.edu.uwr.pum.injectionbasicskotlin.computer.components.*
import javax.inject.Inject

class Computer @Inject constructor (
    private val case: Case,
    private val gpu: GPU,
    private val cpu: CPU,
    private val motherboard: Motherboard,
    private val powerSupply: PowerSupply
        ) {

    var text: String = " "

    fun work(): String{
        return "working"
    }

    @Inject
    fun monitor(monitor: Monitor){
        text = monitor.setComputer(this)
    }
}