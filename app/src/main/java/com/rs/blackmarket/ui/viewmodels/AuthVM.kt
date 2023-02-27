package com.rs.blackmarket.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthVM @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<Boolean>>(Resource.Idle())
    val uiState = _uiState.asStateFlow()
    fun singIn(email: String = "amaury@rootstrap.com", password: String = "P@ssword123") {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.signIn(email, password).collect {
                _uiState.emit(it)
            }
        }
    }

    fun singUp(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.singUp(email, password).collect {
                _uiState.emit(it)
            }
        }
    }

    fun logOut() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.logOut().collect {
                _uiState.emit(it)
            }
        }
    }
}
