package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters

import androidx.room.TypeConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Address

object AddressConverter {

    @TypeConverter
    @JvmStatic
    fun fromAddress (address: Address): String{
        return address.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toAddress(address: String): Address{
        val city = address.substringAfter("city=").substringBefore(",")
        val country = address.substringAfter("country=").substringBefore(",")
        val state = address.substringAfter("state=").substringBefore(",")
        val street_address = address.substringAfter("street_address=").substringBefore(",")
        val street_name = address.substringAfter("street_name=").substringBefore(",")
        val zip_code = address.substringAfter("zip_code=").substringBefore(")")

        return Address(city, country, state, street_address, street_name, zip_code)
    }
}