package com.rs.blackmarket.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoriesVM @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private var _page: Int = 1
    private var _productPageByCategory: Int = 1

    private val _uiState = MutableStateFlow<Resource<List<Category>>>(Resource.Idle())
    val uiState = _uiState.asStateFlow()

    private val _selectedCategory = MutableStateFlow<Resource<Category>>(Resource.Idle())
    val selectedCategory = _selectedCategory.asStateFlow()

    private val _products = MutableStateFlow<Resource<List<Product>>>(Resource.Idle())
    val products = _products.asStateFlow()

    fun loadCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getCategories(_page++).collect {
                _uiState.emit(it)
            }
        }
    }

    fun loadCategoryById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getCategoryById(id).collect {
                _selectedCategory.emit(it)
            }
        }
    }

    fun loadProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getProductsByCategory("Routers", _productPageByCategory++).collect {
                _products.emit(it)
            }
        }
    }
}
