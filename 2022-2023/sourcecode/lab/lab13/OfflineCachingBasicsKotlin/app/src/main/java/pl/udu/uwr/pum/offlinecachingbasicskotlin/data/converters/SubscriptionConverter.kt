package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.converters

import androidx.room.TypeConverter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Subscription

object SubscriptionConverter {

    @TypeConverter
    @JvmStatic
    fun fromSubscription (subscription: Subscription): String{
        return subscription.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toSubscription(subscription: String): Subscription {
        val payment_method = subscription.substringAfter("payment_method=").substringBefore(",")
        val plan = subscription.substringAfter("plan=").substringBefore(",")
        val status = subscription.substringAfter("status=").substringBefore(",")
        val term = subscription.substringAfter("term=").substringBefore(")")

        return Subscription(payment_method, plan, status, term)
    }
}