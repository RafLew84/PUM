package pl.edu.uwr.pum.interfaceinjectibasicskotlin.di

import dagger.Component
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.MainActivity
import pl.edu.uwr.pum.interfaceinjectibasicskotlin.di.modules.AmdModule

@Component(modules = [AmdModule::class])
interface ComputerComponent {
    fun inject(mainActivity: MainActivity)
}