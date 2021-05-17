package io.demo.productsearchapp.redis.subscription.service.impl

import io.demo.productsearchapp.redis.entities.Basket
import io.demo.productsearchapp.redis.subscription.model.Subscriber
import io.demo.productsearchapp.redis.subscription.service.SubscriptionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class DefaultSubscriptionService : SubscriptionService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(DefaultSubscriptionService::class.java)
        val subscribers: MutableSet<Subscriber> = hashSetOf()
    }

    override fun subscribe(subscriber: Subscriber): Subscriber {
        subscribers.add(subscriber)
        return subscriber
    }

    override fun notifySubscribers(basket: Basket) {
        try {
            subscribers.forEach { subscriber ->
                subscriber.send(basket)
                subscriber.onError { error ->
                    logger.info("Seems the subscriber has already dropped out. Remove it from the list")
                    subscriber.completeWithError(error)
                    subscribers.remove(subscriber)
                }
            }
        } catch (ioException: IOException) {
            logger.warn("Failed to notify suscriber about the new basket = {}", basket.id)
        }
    }
}