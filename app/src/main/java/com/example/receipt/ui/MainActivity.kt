package com.example.receipt.ui

import android.app.Activity
import android.icu.util.TimeUnit
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rxjava.rxlife.life
import com.rxjava.rxlife.lifeOnMain
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Observable.timer(5, java.util.concurrent.TimeUnit.SECONDS)
            .lifeOnMain(this)
            .subscribe {

            }

    }

}