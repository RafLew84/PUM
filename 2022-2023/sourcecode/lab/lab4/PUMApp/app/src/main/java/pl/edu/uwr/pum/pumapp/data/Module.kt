package pl.edu.uwr.pum.pumapp.data

data class Module(
    val id: Int,
    val name: String,
    val lecture: Lecture,
    val lab: Lab,
    val apps: App
)
