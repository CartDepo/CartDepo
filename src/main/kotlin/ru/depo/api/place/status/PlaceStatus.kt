package ru.depo.api.place.status

import javax.persistence.*

@Entity
@Table(name = "placestatus", schema = "public")
class PlaceStatus(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "placestateid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String
)