package io.demo.productsearchapp.redis.entities

// import org.redis.ogm.annotation.GeneratedValue
// import org.redis.ogm.annotation.Id
// import org.redis.ogm.annotation.NodeEntity
// import org.redis.ogm.annotation.Relationship

class BasketItem {
    var schedule_id: Long = 0
    var seats: Array<String> = arrayOf<String>()
}