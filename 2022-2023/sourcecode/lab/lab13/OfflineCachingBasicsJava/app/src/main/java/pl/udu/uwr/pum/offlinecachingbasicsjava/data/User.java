package pl.udu.uwr.pum.offlinecachingbasicsjava.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Address;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.CreditCard;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Employment;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.response.Subscription;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    private int id;
    private String uid;
    private String password;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phone_number;
    private String social_insurance_number;
    private String date_of_birth;
    private Employment employment;
    private Address address;
    private CreditCard credit_card;
    private Subscription subscription;

    public User(int id,
                String uid,
                String password,
                String first_name,
                String last_name,
                String username,
                String email,
                String avatar,
                String gender,
                String phone_number,
                String social_insurance_number,
                String date_of_birth,
                Employment employment,
                Address address,
                CreditCard credit_card,
                Subscription subscription) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
        this.phone_number = phone_number;
        this.social_insurance_number = social_insurance_number;
        this.date_of_birth = date_of_birth;
        this.employment = employment;
        this.address = address;
        this.credit_card = credit_card;
        this.subscription = subscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSocial_insurance_number() {
        return social_insurance_number;
    }

    public void setSocial_insurance_number(String social_insurance_number) {
        this.social_insurance_number = social_insurance_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CreditCard getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(CreditCard credit_card) {
        this.credit_card = credit_card;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}