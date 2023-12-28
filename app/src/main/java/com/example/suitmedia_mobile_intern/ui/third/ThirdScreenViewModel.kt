package com.example.suitmedia_mobile_intern.ui.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.suitmedia_mobile_intern.core.data.database.UserRepository
import com.example.suitmedia_mobile_intern.core.data.database.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {
    fun getUsers(): LiveData<PagingData<UserEntity>> =
        userRepository.getUser().cachedIn(viewModelScope)
}
