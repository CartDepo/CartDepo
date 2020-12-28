package ru.depo.api.crash

import ru.depo.api.cart.Cart
import ru.depo.api.crash.status.CrashStatus
import ru.depo.api.crash.type.CrashType
import javax.persistence.*

@Entity
@Table(name = "crash", schema = "public")
class Crash(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "crashid")
        val id: Long? = null,

        @Column(name = "description")
        val description: String,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "typeid")
        val crashType: CrashType,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "crashstatusid")
        val crashStatus: CrashStatus,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "cartid")
        val cart: Cart
)