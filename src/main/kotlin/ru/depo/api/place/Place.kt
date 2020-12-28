package ru.depo.api.place

import ru.depo.api.placeStatus.PlaceStatus
import ru.depo.api.placeType.PlaceType
import javax.persistence.*

@Entity
@Table(name = "place", schema = "public")
class Place(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "placeid")
        val id: Long? = null,

        @Column(name = "number")
        val number: String,

        @JoinColumn(name = "placetypeid")
        @ManyToOne(fetch = FetchType.EAGER)
        val placeType: PlaceType,

        @JoinColumn(name = "placestatusid")
        @ManyToOne(fetch = FetchType.EAGER)
        val placeStatus: PlaceStatus,
)