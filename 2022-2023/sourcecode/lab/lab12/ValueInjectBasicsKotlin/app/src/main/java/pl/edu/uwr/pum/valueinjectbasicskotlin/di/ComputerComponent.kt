package pl.edu.uwr.pum.valueinjectbasicskotlin.di

import dagger.Component
import pl.edu.uwr.pum.valueinjectbasicskotlin.MainActivity
import pl.edu.uwr.pum.valueinjectbasicskotlin.di.modules.GpuModule

@Component(modules = [GpuModule::class])
interface ComputerComponent {
    fun inject(mainActivity: MainActivity)
}