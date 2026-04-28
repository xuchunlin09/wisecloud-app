package com.wisecloud.app.util

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Singleton event bus for token expiration.
 * AuthInterceptor posts events on 401 responses;
 * MainActivity observes and navigates to LoginFragment.
 */
object TokenExpiredEvent {

    private val _events = MutableSharedFlow<Unit>(extraBufferCapacity = 1)
    val events = _events.asSharedFlow()

    fun post() {
        _events.tryEmit(Unit)
    }
}
