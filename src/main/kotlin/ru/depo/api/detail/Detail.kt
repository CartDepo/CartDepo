package ru.depo.api.detail

import ru.depo.api.cart.Cart
import ru.depo.api.detail.type.DetailType
import javax.persistence.*

@Entity
@Table(name = "detail", schema = "public")
class Detail(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "detailid")
        val id: Long? = null,

        @Column(name = "serialnumber")
        val serialNumber: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "detailtypeid")
        val detailType: DetailType,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "cart")
        val cart: Cart
)