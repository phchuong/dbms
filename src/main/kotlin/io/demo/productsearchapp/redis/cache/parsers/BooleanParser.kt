package io.demo.productsearchapp.redis.cache.parsers

object BooleanParser : Parser<Boolean> {
    override fun parse(data: String) = data.toBoolean()
    override fun render(element: Boolean) = element.toString()
}