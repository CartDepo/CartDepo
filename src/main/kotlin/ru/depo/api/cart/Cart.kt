package ru.depo.api.cart

import ru.depo.api.contract.Contract
import ru.depo.api.foreman.Foreman
import ru.depo.api.place.Place
import ru.depo.api.place.type.PlaceType
import ru.depo.api.team.Team
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

        @JoinColumn(name = "teamid")
        @ManyToOne(fetch = FetchType.EAGER)
        val team: Team?,

        @JoinColumn(name = "placeid")
        @ManyToOne(fetch = FetchType.EAGER)
        val place: Place
)