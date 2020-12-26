package ru.depo.api.placeType

import javax.persistence.*

@Entity
@Table(name = "placetype", schema = "depo")
class PlaceType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "placetypeid")
        val id: Long = 0,

        @Column(name = "name")
        val name: String
)