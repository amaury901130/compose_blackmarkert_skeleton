package com.rs.blackmarket.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.rs.blackmarket.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AuthVM @Inject constructor(val authRepository: AuthRepository) : ViewModel()
