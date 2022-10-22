package pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters;

import androidx.room.TypeConverter;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.CreditCard;

public class CreditCardConverter {

    @TypeConverter
    public static String fromCreditCard(CreditCard creditCard){
        return creditCard.getCc_number();
    }

    @TypeConverter
    public static CreditCard toCreditCard(String creditCard){
        return new CreditCard(creditCard);
    }
}
