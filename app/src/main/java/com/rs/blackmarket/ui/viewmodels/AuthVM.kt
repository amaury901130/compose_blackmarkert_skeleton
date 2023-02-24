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
    fun loadTest() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.signIn("amaury@rootstrap.com", "P@ssword123").collect {
                _uiState.emit(it)
            }
        }
    }
}
