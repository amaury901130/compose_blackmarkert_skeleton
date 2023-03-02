package com.rs.blackmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import com.rs.blackmarket.presenter.theme.BlackMarketTheme
import com.rs.blackmarket.presenter.viewmodels.AuthVM
import com.rs.blackmarket.presenter.viewmodels.CategoriesVM
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
fun Greeting(viewModel: AuthVM = hiltViewModel(), categoriesVM: CategoriesVM = hiltViewModel()) {
    val signUpState = viewModel.uiState.collectAsState()
    val categoriesState = categoriesVM.uiState.collectAsState()
    val category = categoriesVM.selectedCategory.collectAsState()
    val products = categoriesVM.products.collectAsState()

    when (val currentState = signUpState.value) {
        is Resource.Loading -> Text(text = "Loading")
        is Resource.Error -> Text(text = currentState.message ?: "Error")
        is Resource.Success -> Column {
            if (products.value is Resource.Success) {
                Text(text = "Products:")
                (products.value as Resource.Success).data?.let { Text(text = it.toString()) }
            } else {
                Button(onClick = { categoriesVM.loadProducts() }) {
                    Text(text = "Load Products")
                }
            }
            if (categoriesState.value is Resource.Success) {
                Text(text = "Categories:")
                (categoriesState.value as Resource.Success).data?.let { Text(text = it.toString()) }
            } else {
                Button(onClick = { categoriesVM.loadCategories() }) {
                    Text(text = "Load Categories")
                }
            }
            if (category.value is Resource.Success) {
                Text(text = "Category detail:")
                (category.value as Resource.Success).data?.let { Text(text = it.toString()) }
            } else {
                Button(onClick = { categoriesVM.loadCategoryById(1) }) {
                    Text(text = "Load Category: 1")
                }
            }
            Button(onClick = { viewModel.logOut() }) {
                Text(text = "Log Out")
            }
        }
        is Resource.Idle -> Button(onClick = { viewModel.singIn() }) {
            Text(text = "Login")
        }
    }
}
