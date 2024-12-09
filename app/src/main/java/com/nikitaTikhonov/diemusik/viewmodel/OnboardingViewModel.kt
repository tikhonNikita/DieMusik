package com.nikitaTikhonov.diemusik.viewmodel

import androidx.lifecycle.ViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel @Inject constructor(): ViewModel() {
    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> get() = _userName

    fun updateUserName(name: String) {
        _userName.value = name
    }

}