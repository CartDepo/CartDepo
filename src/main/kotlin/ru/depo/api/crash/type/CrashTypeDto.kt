package ru.depo.api.crash.type

import java.math.BigDecimal

class CrashTypeDto(
        val id: Long? = null,
        val name: String? = null,
        val description: String? = null,
        val cost: BigDecimal? = null
)