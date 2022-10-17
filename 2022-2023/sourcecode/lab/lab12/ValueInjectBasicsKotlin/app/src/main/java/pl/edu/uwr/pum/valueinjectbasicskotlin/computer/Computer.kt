package pl.edu.uwr.pum.valueinjectbasicskotlin.computer

import pl.edu.uwr.pum.valueinjectbasicskotlin.computer.components.GPU
import javax.inject.Inject

class Computer @Inject constructor(private val gpu: GPU) {
    fun getGpuCores(): String{
        return gpu.gpuCores.toString()
    }
}