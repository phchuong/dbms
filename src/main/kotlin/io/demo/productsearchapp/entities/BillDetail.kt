package io.demo.productsearchapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "billdetail")
data class BillDetail (
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_billdetail: Int = 0,

    var id_bill: Int = 0,
    
    var id_ghe: String = "",

    var id_scheduler: Int = 0
)