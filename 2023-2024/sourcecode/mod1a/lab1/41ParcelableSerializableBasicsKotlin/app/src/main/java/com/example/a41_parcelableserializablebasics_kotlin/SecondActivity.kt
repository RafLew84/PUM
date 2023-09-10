package com.example.a41_parcelableserializablebasics_kotlin

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a41_parcelableserializablebasics_kotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val prop =
            if (SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getParcelableExtra(EXTRA_KEY, Properties::class.java) // min api 33
            else
                intent.getParcelable(EXTRA_KEY) // api 1 - 32

        val serializableProperties =
            if (SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getSerializableExtra(EXTRA_SERIALIZABLE, SerializableProperties::class.java) // min api 33
            else
                intent.getSerializable(EXTRA_SERIALIZABLE) // api 1 - 32


        val parcelizeProperties =
            if (SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                intent.getParcelableExtra(EXTRA_PARCELIZE, ParcelizeProperties::class.java) // min api 33
            else
                intent.getParcelable(EXTRA_PARCELIZE) // api 1 - 32

        (
            prop?.a.toString() + prop?.b.toString() + " " + prop?.c + "----\n" +
            serializableProperties?.a + serializableProperties?.b + " " + serializableProperties?.c + "----\n" +
            parcelizeProperties?.a.toString() + parcelizeProperties?.b.toString() + " " + parcelizeProperties?.c
        ).also { binding.textView.text = it }
    }
}