package pl.edu.uwr.pum.pumapp.data

object DataProvider {
    private val lectures = listOf(
        Lecture(0, "Podstawowe Informacje", listOf("podstawowe informacje", "treści programowe", "warunki zaliczenia")),
        Lecture(1, "Cykl życia aktywności", listOf("Struktura projektu", "Activity", "Cykl życia aktywności", "Stan instancji", "Bundle", "Intent")),
        Lecture(2, "RecyclerView", listOf("RecyclerView", "Adapter", "ViewHolder", "Selector")),
        Lecture(3, "Fragmenty", listOf("Jetpack Navigation", "Navigation Drawer", "Fragment"))
    )

    private val labs = listOf(
        Lab(0, "Przygotowanie layoutu", listOf("LinearLayout", "ConstraintLayout", "Obsługa onClick")),
        Lab(1, "Mechanizm intentów", listOf("Mechanizm intentów - jawne", "Intefejsy Serializable, Parcelable", "Mechanizm intentów - domniemane")),
        Lab(2, "RecyclerView", listOf("RecyclerView", "Selector")),
        Lab(3, "Nawigacja", listOf("Fragmenty statyczne", "Fragmenty dynamiczne", "Navigation Drawer", "RecyclerView"))
    )

    private val apps = listOf(
        App(0, listOf("CounterApp")),
        App(1, listOf("QuizApp")),
        App(2, listOf("WFiApp", "QuickYoga")),
        App(3, listOf("PUMApp"))
    )

    val modules: List<Module>
        get() = (0 until 4).map { Module(
            it,
            "Moduł $it",
            lectures[it],
            labs[it],
            apps[it]
        ) }
}