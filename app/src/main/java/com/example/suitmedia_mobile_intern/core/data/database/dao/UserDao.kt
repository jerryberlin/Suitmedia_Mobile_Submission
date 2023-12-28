package com.example.suitmedia_mobile_intern.core.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.suitmedia_mobile_intern.core.data.database.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUser(): PagingSource<Int, UserEntity>

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}