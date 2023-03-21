package com.rs.blackmarket.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

//TODO: setup your dispatchers behavior here
//Check best practices here: https://developer.android.com/kotlin/coroutines/coroutines-best-practices
sealed class AppDispatchers(open val thread: CoroutineDispatcher) {
    data class IO(
        override val thread: CoroutineDispatcher = Dispatchers.IO
    ) : AppDispatchers(thread)

    data class MAIN(
        override val thread: CoroutineDispatcher = Dispatchers.Main
    ) : AppDispatchers(thread)

    data class DEFAULT(
        override val thread: CoroutineDispatcher = Dispatchers.Default
    ) : AppDispatchers(thread)
}
