package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse

data class Subscription(
    val payment_method: String,
    val plan: String,
    val status: String,
    val term: String
)