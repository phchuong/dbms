package io.demo.productsearchapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movietime")
data class MovieTime (
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    var movie: Int = 0,
    
    var theater: Int = 0,
    
    var date: String = "",
    
    var payment:  Int = 0,
    
    var discount:  Int = 0
)