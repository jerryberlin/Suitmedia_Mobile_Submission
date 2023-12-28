package com.example.suitmedia_mobile_intern.core.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.suitmedia_mobile_intern.core.data.UserRemoteMediator
import com.example.suitmedia_mobile_intern.core.data.database.entity.UserEntity
import com.example.suitmedia_mobile_intern.core.data.network.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDatabase: UserDatabase,
    private val apiService: ApiService
) {

    fun getUser(): LiveData<PagingData<UserEntity>> {
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            remoteMediator = UserRemoteMediator(userDatabase, apiService),
            pagingSourceFactory = {
                userDatabase.userDao().getAllUser()
            }
        ).flow.asLiveData()
    }

}