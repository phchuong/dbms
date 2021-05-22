package io.demo.productsearchapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.OneToMany
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
@Table(name = "Bill")
data class Bill (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var userId: String = "",
    var schedule_id: Int = 0,
    var unit_price: Int = 0,
    var discount: Int = 0,
    var total_price: Int = 0,


    @JsonManagedReference
    @Column(nullable = true)
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "id_bill")
    public val seats: List<BillDetail> = mutableListOf() 
)