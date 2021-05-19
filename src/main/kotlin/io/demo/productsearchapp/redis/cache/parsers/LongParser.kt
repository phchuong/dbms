package io.demo.productsearchapp.redis.cache.parsers

object LongParser : Parser<Long> {
    override fun parse(data: String) = data.toLong()
    override fun render(element: Long) = element.toString()
}