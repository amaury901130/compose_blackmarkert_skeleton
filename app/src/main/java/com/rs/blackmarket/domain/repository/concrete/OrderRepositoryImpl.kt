package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.extensions.parse
import com.rs.blackmarket.domain.model.Order
import com.rs.blackmarket.domain.model.OrderItem
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.model.ShoppingCart
import com.rs.blackmarket.domain.repository.OrderRepository
import com.rs.data.model.Data
import com.rs.data.remote.CartRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrderRepositoryImpl(private val cartRemoteDs: CartRemoteDs) : OrderRepository {
    override suspend fun addProduct(productId: Int, quantity: Int): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        when (
            val response = cartRemoteDs.addProduct(productId, quantity)
        ) {
            is Data.Success -> emit(Resource.Success(true))
            is Data.Error -> emit(
                Resource.Error(
                    response.errorMessages?.values?.first()?.toString()
                )
            )
        }
    }

    override suspend fun removeProduct(productId: Int): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        when (
            val response = cartRemoteDs.removeProduct(productId)
        ) {
            is Data.Success -> emit(Resource.Success(true))
            is Data.Error -> emit(
                Resource.Error(
                    response.errorMessages?.values?.first()?.toString()
                )
            )
        }
    }

    override suspend fun completePurchase(
        city: String,
        country: String,
        address1: String,
        address2: String,
        postalCode: String,
        cardNumber: String,
        cvcCard: String,
        expMonth: Int,
        expYear: Int,
        cardName: String
    ): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val response = cartRemoteDs.completePurchase(
            city,
            country,
            address1,
            address2,
            postalCode,
            cardNumber,
            cvcCard,
            expMonth,
            expYear,
            cardName
        )

        when (response) {
            is Data.Success -> emit(Resource.Success(true))
            is Data.Error -> emit(
                Resource.Error(
                    response.errorMessages?.values?.first()?.toString()
                )
            )
        }
    }

    override suspend fun getShoppingCart(): Flow<Resource<ShoppingCart>> = flow {
        emit(Resource.Loading())
        when (val response = cartRemoteDs.getShoppingCart()) {
            is Data.Success -> emit(Resource.Success(ShoppingCart.parse(response.data)))
            is Data.Error -> emit(Resource.Error())
        }
    }

    override suspend fun getOrders(page: Int): Flow<Resource<List<Any>>> = flow {
        emit(Resource.Loading())
        when (val response = cartRemoteDs.getOrders(page)) {
            is Data.Success -> {
                emit(Resource.Success(response.data?.map { Order.parse(it) } ?: emptyList()))
            }
            is Data.Error -> emit(Resource.Error())
        }
    }

    override suspend fun getOrdersProducts(page: Int): Flow<Resource<List<OrderItem>>> = flow {
        emit(Resource.Loading())
        when (val response = cartRemoteDs.getOrdersProducts(page)) {
            is Data.Success -> {
                emit(Resource.Success(response.data?.map { OrderItem.parse(it) } ?: emptyList()))
            }
            is Data.Error -> emit(Resource.Error())
        }
    }
}
