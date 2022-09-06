package pl.udu.uwr.pum.mvcbascicskotlin

data class Model (
    private val text: String,
    private val score: Int,
    private val ratio: Int)
{
    fun getData(): String{
        return "$text $score $ratio"
    }
}