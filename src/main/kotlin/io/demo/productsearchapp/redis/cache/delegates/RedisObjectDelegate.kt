package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import io.demo.productsearchapp.redis.cache.path
import kotlin.reflect.KProperty

class RedisObjectDelegate<T : RedisObject>(val factory: (String) -> T) {
    operator fun getValue(ref: RedisObject, property: KProperty<*>): T {
        val path = path(ref, property)
        return factory(path)
    }
}