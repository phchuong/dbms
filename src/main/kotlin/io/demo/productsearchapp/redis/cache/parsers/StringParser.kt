package io.demo.productsearchapp.redis.cache.parsers

object StringParser : Parser<String> {
    override fun parse(data: String) = data
    override fun render(element: String) = element
}