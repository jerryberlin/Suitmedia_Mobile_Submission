package com.example.suitmedia_mobile_intern.core.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class UserEntity(

    @PrimaryKey
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,


    @field:SerializedName("avatar")
    val avatar: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("email")
    val email: String? = null
) : Parcelable