package com.example.suitmedia_mobile_intern.core.di

import android.content.Context
import androidx.room.Room
import com.example.suitmedia_mobile_intern.core.data.database.UserDatabase
import com.example.suitmedia_mobile_intern.core.data.database.dao.RemoteKeysDao
import com.example.suitmedia_mobile_intern.core.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java, "User.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideRemoteKeysDao(database: UserDatabase): RemoteKeysDao = database.remoteKeysDao()

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.userDao()
}