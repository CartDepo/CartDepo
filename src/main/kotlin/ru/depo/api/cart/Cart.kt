package ru.depo.api.cart

import ru.depo.api.contract.Contract
import ru.depo.api.foreman.Foreman
import ru.depo.api.place.Place
import ru.depo.api.place.type.PlaceType
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

        @JoinColumn(name = "contractid")
        @ManyToOne(fetch = FetchType.EAGER)
        val contract: Contract,

        @JoinColumn(name = "foremanid")
        @ManyToOne(fetch = FetchType.EAGER)
        val foreman: Foreman,

        @JoinColumn(name = "placeid")
        @ManyToOne(fetch = FetchType.EAGER)
        val place: Place,

        @JoinColumn(name = "placetype")
        @ManyToOne(fetch = FetchType.EAGER)
        val placeType: PlaceType
)