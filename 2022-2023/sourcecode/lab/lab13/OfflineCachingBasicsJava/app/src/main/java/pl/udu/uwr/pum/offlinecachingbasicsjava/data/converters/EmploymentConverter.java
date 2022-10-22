package pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters;

import androidx.room.TypeConverter;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Employment;

public class EmploymentConverter {
    @TypeConverter
    public static String fromEmployment(Employment employment){
        return employment.getTitle();
    }

    @TypeConverter
    public static Employment toEmployment(String employment){
        return new Employment(employment);
    }

}
