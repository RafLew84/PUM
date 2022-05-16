package pl.edu.uwr.pum.parcelableexamplekotlin

import android.os.Parcel
import android.os.Parcelable

class Properties(val a: Int, val b: Int, val c: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(a)
        parcel.writeInt(b)
        parcel.writeString(c)
    }

    override fun describeContents(): Int {
        return hashCode()
    }

    companion object CREATOR : Parcelable.Creator<Properties> {
        override fun createFromParcel(parcel: Parcel): Properties {
            return Properties(parcel)
        }

        override fun newArray(size: Int): Array<Properties?> {
            return arrayOfNulls(size)
        }
    }
}