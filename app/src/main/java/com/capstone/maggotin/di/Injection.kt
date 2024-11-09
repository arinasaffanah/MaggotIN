package com.capstone.maggotin.di

import android.content.Context
import com.capstone.maggotin.data.UserRepository
import com.capstone.maggotin.data.pref.UserPreference
import com.capstone.maggotin.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}