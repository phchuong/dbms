package io.demo.productsearchapp.redis.entities

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Reference
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("Basket")
data class Basket (
    @Indexed @get:Id var id: Long? = null,
    @get:Reference var items: List<BasketItem>? = emptyList()
)