package ru.depo.api.crash

import ru.depo.api.cart.CartDto
import ru.depo.api.crash.status.CrashStatusDto
import ru.depo.api.crash.type.CrashTypeDto

class CrashDto(
        val id: Long?,
        val description: String?,
        val crashType: CrashTypeDto?,
        val crashStatus: CrashStatusDto?,
        val cart: CartDto?
)