package pl.udu.uwr.pum.offlinecachingbasicskotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Address
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.CreditCard
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Employment
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.reponse.Subscription

@Entity(tableName = "users")
data class User(
    val address: Address,
    val avatar: String,
    val credit_card: CreditCard,
    val date_of_birth: String,
    val email: String,
    val employment: Employment,
    val first_name: String,
    val gender: String,
    @PrimaryKey val id: Int,
    val last_name: String,
    val password: String,
    val phone_number: String,
    val social_insurance_number: String,
    val subscription: Subscription,
    val uid: String,
    val username: String
)