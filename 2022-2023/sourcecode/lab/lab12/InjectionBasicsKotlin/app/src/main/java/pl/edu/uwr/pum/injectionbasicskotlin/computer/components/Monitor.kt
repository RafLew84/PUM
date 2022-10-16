package pl.edu.uwr.pum.injectionbasicskotlin.computer.components

import pl.edu.uwr.pum.injectionbasicskotlin.computer.Computer
import javax.inject.Inject

class Monitor @Inject constructor() {
    fun setComputer(computer: Computer): String{
        return "monitor connected"
    }
}