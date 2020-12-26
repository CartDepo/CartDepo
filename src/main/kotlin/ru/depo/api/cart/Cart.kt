package ru.depo.api.cart

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cart", schema = "depo")
class Cart(
    @Id
    @Column(name = "cartid")
    val id: Long,

    @Column(name = "number")
    val number: String,

    @Column(name = "cartyear")
    val year: Int?,

    @Column(name = "contractid")
    val contract: Long,

    @Column(name = "foremanid")
    val foreman: Long,

    @Column(name = "placeid")
    val place: Long
)