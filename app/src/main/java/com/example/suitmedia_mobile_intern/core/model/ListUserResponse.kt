package com.example.suitmedia_mobile_intern.core.model

import com.google.gson.annotations.SerializedName

data class ListUserResponse(
    @field:SerializedName("data")
    val data: List<UserResponse?>? = null,
)

