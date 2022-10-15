package pl.edu.uwr.pum.dagger2basicskotlin.computer

import pl.edu.uwr.pum.dagger2basicskotlin.computer.components.*
import javax.inject.Inject

class Computer @Inject constructor (
    private val case: Case,
    private val gpu: GPU,
    private val cpu: CPU,
    private val motherboard: Motherboard,
    private val powerSupply: PowerSupply
        ) {
    fun work(): String{
        return "working"
    }
}