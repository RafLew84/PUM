package pl.udu.uwr.pum.mvcbascicskotlin

import android.widget.TextView

class MyView (private val textView: TextView, private val model: Model){
    fun display(){
        textView.text = model.getData()
    }
}