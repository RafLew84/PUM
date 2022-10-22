package pl.udu.uwr.pum.offlinecachingbasicsjava.data.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Subscription;

public class SubscriptionConverter {
    @TypeConverter
    public static String fromSubscription(Subscription subscription){
        Gson gson = new Gson();
        return gson.toJson(subscription);
    }

    @TypeConverter
    public  static Subscription toSubscription(String subscription){
        Gson gson = new Gson();
        return gson.fromJson(subscription, Subscription.class);
    }
}
