package pl.udu.uwr.pum.taskykotlin.model


data class TaskGroup (val name: String)
data class Task(val name: String, val type: TaskGroup)