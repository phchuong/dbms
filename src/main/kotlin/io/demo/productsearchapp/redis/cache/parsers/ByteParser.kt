package io.demo.productsearchapp.redis.cache.parsers

object ByteParser : Parser<Byte> {
    override fun parse(data: String) = data.toByte()
    override fun render(element: Byte) = element.toString()
}