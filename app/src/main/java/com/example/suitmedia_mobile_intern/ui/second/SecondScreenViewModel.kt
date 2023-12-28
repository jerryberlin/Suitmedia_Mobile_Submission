package com.example.suitmedia_mobile_intern.ui.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.suitmedia_mobile_intern.DataStorePref
import com.example.suitmedia_mobile_intern.core.model.UserSession
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(private val dataStorePref: DataStorePref) :
    ViewModel() {
    fun getSession(): LiveData<UserSession> {
        return dataStorePref.getSession().asLiveData()
    }
}