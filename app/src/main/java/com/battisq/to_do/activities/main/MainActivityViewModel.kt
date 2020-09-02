package com.battisq.to_do.activities.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.battisq.to_do.database.AppDatabase
import com.battisq.to_do.utilits.DATABASE

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(onSuccess: () -> Unit) {
        DATABASE = AppDatabase.getInstance(mContext)
        onSuccess()
    }
}