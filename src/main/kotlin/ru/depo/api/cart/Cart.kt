package ru.depo.api.cart

import javax.persistence.*

@Entity
@Table(name = "cart", schema = "public")
class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    val id: Long? = null,

    @Column(name = "number")
    val number: String,

    @Column(name = "cartyear")
    val year: Int?,

    @Column(name = "contractid")
    val contract: Long,

    @Column(name = "foremanid")
    val foreman: Long,

    @Column(name = "placeid")
    val place: Long,

    @Column(name = "placetype")
    val placeType: Long
)