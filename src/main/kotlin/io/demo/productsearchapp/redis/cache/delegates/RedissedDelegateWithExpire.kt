package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import io.demo.productsearchapp.redis.cache.ttl
import io.demo.productsearchapp.redis.cache.expire
import kotlin.reflect.KProperty

class RedissedDelegateWithExpire<T>(
    private val delegate: RedissedDelegate<T>
) : RedissedDelegate<Pair<T, Int>> {

    override fun getValue(ref: RedisObject, property: KProperty<*>): Pair<T, Int> {
        val con = ref.commands
        val value = delegate.getValue(ref, property)
        val ttl = ttl(ref, property)

        return value to ttl.toInt()
    }

    override fun setValue(ref: RedisObject, property: KProperty<*>, value: Pair<T, Int>) {
        val (value, expire) = value

        delegate.setValue(ref, property, value)
        expire(ref, property, expire)
    }
}