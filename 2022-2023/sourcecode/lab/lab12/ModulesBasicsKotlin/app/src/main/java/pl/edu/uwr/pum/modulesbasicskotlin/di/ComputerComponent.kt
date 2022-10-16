package pl.edu.uwr.pum.modulesbasicskotlin.di

import dagger.Component
import pl.edu.uwr.pum.modulesbasicskotlin.MainActivity
import pl.edu.uwr.pum.modulesbasicskotlin.di.modules.ComputerModule

@Component(modules = [ComputerModule::class])
interface ComputerComponent {
    fun inject(activity: MainActivity)
}