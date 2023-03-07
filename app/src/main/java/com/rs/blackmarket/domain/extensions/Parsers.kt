package com.rs.blackmarket.domain.extensions

import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.ProductStatus
import com.rs.data.model.entity.CategoryEntity
import com.rs.data.model.entity.ProductEntity

fun Category.Companion.parse(entity: CategoryEntity): Category = Category(
    id = entity.id,
    name = entity.name,
    imageUrl = entity.picture,
    subCategories = entity.subCategories?.map { Category.parse(it) }?.toList() ?: emptyList()
)

fun Product.Companion.parse(entity: ProductEntity): Product = Product(
    id = entity.id,
    name = entity.name,
    image = entity.productPicture,
    isFav = entity.isFavorite,
    description = entity.description,
    gallery = entity.productPictures ?: emptyList(),
    price = entity.unitPrice?.toDouble() ?: 0.0,
    totalItems = entity.numAvailableItems,
    categories = entity.categories.map { cat -> Category.parse(cat) },
    //TODO=
    status = ProductStatus.NEW
)
