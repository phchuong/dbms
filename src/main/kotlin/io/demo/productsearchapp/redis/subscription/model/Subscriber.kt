package io.demo.productsearchapp.redis.subscription.model

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

class Subscriber : SseEmitter(Long.MAX_VALUE)