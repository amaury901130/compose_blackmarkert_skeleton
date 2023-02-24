package com.rs.blackmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.ui.theme.BlackMarketTheme
import com.rs.blackmarket.ui.viewmodels.AuthVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackMarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: AuthVM = hiltViewModel()) {
    val signUpState = viewModel.uiState.collectAsState()
    when (val currentState = signUpState.value) {
        is Resource.Loading -> Text(text = "Loading")
        is Resource.Error -> Text(text = currentState.message ?: "SignUp Error")
        is Resource.Success -> Text(text = "Success")
        is Resource.Idle -> Button(onClick = { viewModel.loadTest() }) {
            Text(text = "Login")
        }
    }
}
