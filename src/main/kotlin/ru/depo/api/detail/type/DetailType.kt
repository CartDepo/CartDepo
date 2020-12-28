package ru.depo.api.detail.type

import javax.persistence.*

@Entity
@Table(name = "detailtype", schema = "public")
class DetailType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "detailtypeid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "amount")
        val amount: Long
)