package io.demo.productsearchapp.redis.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import io.demo.productsearchapp.redis.entities.Basket
import io.demo.productsearchapp.redis.entities.BasketItem
import io.demo.productsearchapp.redis.subscription.service.SubscriptionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class MovieBookingListener(val objectMapper: ObjectMapper, val subscriptionService: SubscriptionService) : MessageListener {

    companion object {
        val logger : Logger = LoggerFactory.getLogger(MovieBookingListener::class.java)
    }

    override fun onMessage(message: Message, pattern: ByteArray?) {
        val basket = manualMap(message)
        subscriptionService.notifySubscribers(basket)
        logger.info("Notified on a new Movie creation {}", basket.id)
    }

    fun manualMap(message: Message) : Basket {
        val bastketMap = objectMapper.readValue(message.toString(), Map::class.java)
        val basket = Basket(bastketMap["id"] as Long, bastketMap["items"] as List<BasketItem>)
        return basket
    }
}