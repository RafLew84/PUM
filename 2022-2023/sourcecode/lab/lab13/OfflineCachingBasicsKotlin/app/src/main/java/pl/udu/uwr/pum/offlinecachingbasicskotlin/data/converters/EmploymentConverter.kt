package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters

import androidx.room.TypeConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Employment

object EmploymentConverter {

    @TypeConverter
    @JvmStatic
    fun fromEmployment (employment: Employment): String{
        return employment.title
    }

    @TypeConverter
    @JvmStatic
    fun toEmployment(employment: String): Employment {

        return Employment(employment, employment)
    }
}