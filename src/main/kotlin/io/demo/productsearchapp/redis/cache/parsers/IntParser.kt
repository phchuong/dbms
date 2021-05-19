package io.demo.productsearchapp.redis.cache.parsers

object IntParser : Parser<Int> {
    override fun parse(data: String) = data.toInt()
    override fun render(element: Int) = element.toString()
}