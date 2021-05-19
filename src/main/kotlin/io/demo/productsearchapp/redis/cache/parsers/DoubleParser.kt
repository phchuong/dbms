package io.demo.productsearchapp.redis.cache.parsers

object DoubleParser : Parser<Double> {
    override fun parse(data: String) = data.toDouble()
    override fun render(element: Double) = element.toString()
}