package com.example.receipt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val retrofit by inject<Retrofit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit
        retrofit
    }

}