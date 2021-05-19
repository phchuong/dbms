package io.demo.productsearchapp.redis.cache.delegates

import io.demo.productsearchapp.redis.cache.RedisObject
import io.demo.productsearchapp.redis.cache.get
import io.demo.productsearchapp.redis.cache.setNullable
import io.demo.productsearchapp.redis.cache.parsers.Parser
import kotlin.reflect.KProperty

class ParserDelegateNullable<T>(
    val parser: Parser<T>
) : RedissedDelegateNullable<T> {

    override operator fun getValue(ref: RedisObject, property: KProperty<*>): T? {
        return get(ref, property)?.let { parser.parse(it) }
    }

    override operator fun setValue(ref: RedisObject, property: KProperty<*>, value: T?) {
        val render = value?.let { parser.render(it) }
        setNullable(render, ref, property)
    }
}