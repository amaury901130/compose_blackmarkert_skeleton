package com.rs.blackmarket.domain.model

data class Product(
    val id: Int,
    val name: String,
    val description: String? = null,
    val image: String? = null,
    val gallery: List<String> = emptyList(),
    val price: Double = 0.0,
    val isFav: Boolean = false,
    val totalItems: Int,
    val categories: List<Category>,
    val status: ProductStatus
) {
    companion object
}

enum class ProductStatus(val queryValue: String) {
    NEW("N"), USED("U"), SEMI_NEW("A")
}
