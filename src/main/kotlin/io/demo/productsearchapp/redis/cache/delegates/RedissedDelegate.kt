package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import kotlin.reflect.KProperty

interface RedissedDelegate<T> {
    operator fun getValue(ref: RedisObject, property: KProperty<*>): T
    operator fun setValue(ref: RedisObject, property: KProperty<*>, value: T)
}