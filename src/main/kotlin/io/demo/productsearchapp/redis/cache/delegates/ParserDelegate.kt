package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import io.demo.productsearchapp.redis.cache.get
import io.demo.productsearchapp.redis.cache.set
import io.demo.productsearchapp.redis.cache.parsers.Parser
import kotlin.reflect.KProperty

class ParserDelegate<T>(
    val parser: Parser<T>,
    val default: T
) : RedissedDelegate<T> {

    override operator fun getValue(ref: RedisObject, property: KProperty<*>): T {
        return get(ref, property)?.let { parser.parse(it) } ?: default
    }

    override operator fun setValue(ref: RedisObject, property: KProperty<*>, value: T) {
        set(parser.render(value), ref, property)
    }
}