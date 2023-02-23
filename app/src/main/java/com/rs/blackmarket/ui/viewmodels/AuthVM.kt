package com.rs.blackmarket.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.blackmarket.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthVM @Inject constructor(val authRepository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(false)
    val uiState = _uiState.asStateFlow()
    fun loadTest() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.createAccount("sample@rs.com", "sample", "password").collect {
                _uiState.value = it
            }
        }
    }
}
