package ru.depo.api.place.type

import javax.persistence.*

@Entity
@Table(name = "placetype", schema = "public")
class PlaceType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "placetypeid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String
)