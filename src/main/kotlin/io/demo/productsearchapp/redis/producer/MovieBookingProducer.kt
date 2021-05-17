package io.demo.productsearchapp.redis.producer

import io.demo.productsearchapp.redis.entities.Basket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Component

@Component
class MovieBookingProducer(val template: RedisTemplate<String, Any>, val channelTopic: ChannelTopic) {

    companion object {
        val logger : Logger = LoggerFactory.getLogger(MovieBookingProducer::class.java)
    }

    fun publish(basket: Basket) {
        // logger.info("Notifying subscribers on adding a new Movie {} {}", movie.id, movie.name)
        template.convertAndSend(channelTopic.topic, basket)
    }
}