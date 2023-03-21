package com.rs.blackmarket.domain.model


enum class ProductStatus(val queryValue: String) {
    NEW("N"), USED("U"), RESTORED("A");

    companion object
}

fun ProductStatus.Companion.fromValue(value: String? = "A") =
    ProductStatus.values().find { it.queryValue == value } ?: ProductStatus.USED
