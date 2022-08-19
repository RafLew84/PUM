package pl.udu.uwr.pum.taskykotlin.model

sealed class TaskRow(val rowType: Int) {
    data class Task(val name: String) :
        TaskRow(TYPE_TASK)

    data class Header(val name: String, var isExpanded: Boolean = true) : TaskRow(TYPE_HEADER)

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_TASK = 1
    }
}