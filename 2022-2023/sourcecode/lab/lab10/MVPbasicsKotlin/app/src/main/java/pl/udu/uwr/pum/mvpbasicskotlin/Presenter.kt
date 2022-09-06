package pl.udu.uwr.pum.mvpbasicskotlin

class Presenter(private val myView: MyView) {

    fun getData(): Model {
        return Model("text", 1, 2)
    }

    fun getDetails() {
        myView.onDisplay(getData().getData())
    }
}