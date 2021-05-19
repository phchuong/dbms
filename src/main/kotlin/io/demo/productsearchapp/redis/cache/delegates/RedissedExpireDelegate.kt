package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import io.demo.productsearchapp.redis.cache.expire
import kotlin.reflect.KProperty

class RedissedExpireDelegate<T>(
    val seconds: Int,
    private val delegate: RedissedDelegate<T>
) : RedissedDelegate<T> by delegate {

    override fun setValue(ref: RedisObject, property: KProperty<*>, value: T) {
        delegate.setValue(ref, property, value)
        expire(ref, property, seconds)
    }
}
