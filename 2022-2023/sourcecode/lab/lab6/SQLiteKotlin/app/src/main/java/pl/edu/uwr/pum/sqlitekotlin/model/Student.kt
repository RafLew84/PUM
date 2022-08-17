package pl.edu.uwr.pum.sqlitekotlin.model

data class Student(val name: String, val index: Int) {
    var id: Int = 0

    constructor(id: Int, name: String, index: Int) : this(name, index) {
        this.id = id
    }
}