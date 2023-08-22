package com.example.a41_parcelableserializablebasics_kotlin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ParcelizeProperties (val a: Int, val b: Int, val c: String) : Parcelable