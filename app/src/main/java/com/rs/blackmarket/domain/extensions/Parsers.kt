package com.rs.blackmarket.domain.extensions

import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Order
import com.rs.blackmarket.domain.model.OrderItem
import com.rs.blackmarket.domain.model.ShoppingCartItem
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.ProductStatus
import com.rs.blackmarket.domain.model.ShoppingCart
import com.rs.blackmarket.domain.model.fromValue
import com.rs.data.model.entity.CategoryEntity
import com.rs.data.model.entity.OrderEntity
import com.rs.data.model.entity.OrderProductEntity
import com.rs.data.model.entity.OrderResumeEntity
import com.rs.data.model.entity.ProductEntity
import com.rs.data.model.entity.ShoppingCartEntity

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
    status = ProductStatus.fromValue(entity.state)
)

fun ShoppingCart.Companion.parse(entity: ShoppingCartEntity?): ShoppingCart {
    return entity?.run {
        ShoppingCart(
            total = entity.totalPrice,
            products = entity.orderProducts.map { ShoppingCartItem.parse(it) }
        )
    } ?: ShoppingCart()
}

fun ShoppingCartItem.Companion.parse(entity: OrderResumeEntity): ShoppingCartItem {
    return ShoppingCartItem(
        Product.parse(entity.product),
        quantity = entity.quantity,
        totalPrice = entity.totalProductPrice,
        unitPrice = entity.unitPrice
    )
}

fun Order.Companion.parse(entity: OrderEntity): Order {
    return Order(
        id = entity.id,
        paymentStatus = entity.paymentStatus,
        date = entity.dateBought,
        city = entity.addressCity,
        address = "${entity.addressLine1}, ${entity.addressLine2}",
        orderProducts = entity.orderProducts.map { ShoppingCartItem.parse(it) }
    )
}

fun OrderItem.Companion.parse(entity: OrderProductEntity): OrderItem {
    return OrderItem(
        productId = entity.id,
        orderId = entity.orderId,
        dateBought = entity.productDateBought,
        productName = entity.productName,
        productPicture = entity.productPicture,
        quantity = entity.quantity,
        orderPrice = entity.totalProductPrice,
        price = entity.unitPrice,
    )
}
