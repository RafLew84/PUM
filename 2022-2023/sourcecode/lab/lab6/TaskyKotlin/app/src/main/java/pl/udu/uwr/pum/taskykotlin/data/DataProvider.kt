package pl.udu.uwr.pum.taskykotlin.data

import pl.udu.uwr.pum.taskykotlin.model.Task
import pl.udu.uwr.pum.taskykotlin.model.TaskGroup
import pl.udu.uwr.pum.taskykotlin.model.TaskRow

object DataProvider {
    val dummyData = listOf(
        Task("task1", TaskGroup("Group 1")),
        Task("task2", TaskGroup("Group 1")),
        Task("task3", TaskGroup("Group 1")),
        Task("task4", TaskGroup("Group 1")),
        Task("task5", TaskGroup("Group 1")),
        Task("task a", TaskGroup("Group 2")),
        Task("task b", TaskGroup("Group 2")),
        Task("task c", TaskGroup("Group 2")),
        Task("task d", TaskGroup("Group 2"))
    )
}