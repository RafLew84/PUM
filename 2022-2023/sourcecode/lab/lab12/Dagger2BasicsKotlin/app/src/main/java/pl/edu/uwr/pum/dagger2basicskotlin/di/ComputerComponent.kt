package pl.edu.uwr.pum.dagger2basicskotlin.di

import dagger.Component
import pl.edu.uwr.pum.dagger2basicskotlin.computer.Computer

@Component
interface ComputerComponent {
    fun getComputer(): Computer
}