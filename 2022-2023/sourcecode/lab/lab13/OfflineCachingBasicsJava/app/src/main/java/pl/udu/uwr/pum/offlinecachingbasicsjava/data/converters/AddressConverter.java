package pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Address;

public class AddressConverter {

    @TypeConverter
    public static String fromAddress(Address address){
        Gson gson = new Gson();
        return gson.toJson(address);
    }

    @TypeConverter
    public static Address toAddress(String address){
        Gson gson = new Gson();
        return gson.fromJson(address, Address.class);
    }
}
