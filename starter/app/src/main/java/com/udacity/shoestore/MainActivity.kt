package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

/**
 * Creates an Activity that hosts all of the fragments in the app
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}
