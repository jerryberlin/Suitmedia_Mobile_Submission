package com.example.suitmedia_mobile_intern.core.data.network

import com.example.suitmedia_mobile_intern.core.model.ListUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") size: Int
    ): ListUserResponse
}