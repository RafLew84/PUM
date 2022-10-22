package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse

data class Address(
    val city: String,
    val country: String,
    val state: String,
    val street_address: String,
    val street_name: String,
    val zip_code: String
)