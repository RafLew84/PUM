package pl.edu.uwr.pum.pumapp.data

object DataProvider {
    private val lectures = listOf(
        Lecture(0, "Wykład 1", listOf("podstawowe informacje", "treści programowe", "warunki zaliczenia")),
        Lecture(1, "Wykład 2", listOf("Struktura projektu", "Activity", "Cykl życia aktywności", "Stan instancji", "Bundle", "Intent")),
        Lecture(2, "Wykład 3", listOf("RecyclerView", "Adapter", "ViewHolder", "Selector"))
    )

    private val labs = listOf(
        Lab(0, "Lab 1", listOf("LinearLayout", "ConstraintLayout", "Obsługa onClick")),
        Lab(1, "Lab 2", listOf("Mechanizm intentów - jawne", "Intefejsy Serializable, Parcelable", "Mechanizm intentów - domniemane")),
        Lab(2, "Lab 3", listOf("RecyclerView", "Selector"))
    )

    private val apps = listOf(
        App(0, listOf("CounterApp")),
        App(1, listOf("QuizApp")),
        App(2, listOf("WFiApp", "QuickYoga"))
    )

    val modules: List<Module>
        get() = (0 until 3).map { Module(
            it,
            "Moduł $it",
            lectures[it],
            labs[it],
            apps[it]
        ) }
}