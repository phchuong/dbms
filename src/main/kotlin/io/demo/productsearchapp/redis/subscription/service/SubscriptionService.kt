package io.demo.productsearchapp.redis.subscription.service

import io.demo.productsearchapp.redis.entities.Basket
import io.demo.productsearchapp.redis.subscription.model.Subscriber

interface SubscriptionService {

    fun subscribe(subscriber: Subscriber): Subscriber

    fun notifySubscribers(basket: Basket)
}