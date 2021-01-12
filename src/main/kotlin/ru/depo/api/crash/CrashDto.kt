package ru.depo.api.crash

import ru.depo.api.cart.CartDto
import ru.depo.api.crash.status.CrashStatusDto
import ru.depo.api.crash.type.CrashTypeDto

class CrashDto(
    val id: Long? = null,
    val description: String? = null,
    val crashType: CrashTypeDto? = null,
    val crashStatus: CrashStatusDto? = null,
    val cart: CartDto? = null
)