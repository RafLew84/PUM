package pl.edu.uwr.pum.injectionbasicskotlin.di

import dagger.Component
import pl.edu.uwr.pum.injectionbasicskotlin.MainActivity
import pl.edu.uwr.pum.injectionbasicskotlin.computer.Computer

@Component
interface ComputerComponent {
    fun inject(activity: MainActivity)
}