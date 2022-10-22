package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters

import androidx.room.TypeConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Address
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.CreditCard

object CreditCardConverter {
    @TypeConverter
    @JvmStatic
    fun fromCreditCard (creditCard: CreditCard): String{
        return creditCard.cc_number
    }

    @TypeConverter
    @JvmStatic
    fun toCreditCard(creditCard: String): CreditCard {

        return CreditCard(creditCard)
    }
}