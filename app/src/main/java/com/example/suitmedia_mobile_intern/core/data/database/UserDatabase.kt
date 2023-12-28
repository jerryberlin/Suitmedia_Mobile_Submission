package com.example.suitmedia_mobile_intern.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.suitmedia_mobile_intern.core.data.database.dao.RemoteKeysDao
import com.example.suitmedia_mobile_intern.core.data.database.dao.UserDao
import com.example.suitmedia_mobile_intern.core.data.database.entity.UserEntity

@Database(
    entities = [UserEntity::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}