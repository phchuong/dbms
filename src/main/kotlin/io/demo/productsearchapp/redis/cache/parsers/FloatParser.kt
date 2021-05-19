package io.demo.productsearchapp.redis.cache.parsers

object FloatParser : Parser<Float> {
    override fun parse(data: String) = data.toFloat()
    override fun render(element: Float) = element.toString()
}