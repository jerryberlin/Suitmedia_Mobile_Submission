package com.example.suitmedia_mobile_intern.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.suitmedia_mobile_intern.DataStorePref
import com.example.suitmedia_mobile_intern.core.model.UserSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(private val dataStorePref: DataStorePref) :
    ViewModel() {
    fun saveSession(userSession: UserSession) {
        viewModelScope.launch {
            dataStorePref.saveSession(userSession)
        }
    }
}