package ru.depo.api.crash

import ru.depo.api.cart.CartMapper
import ru.depo.api.crash.status.CrashStatusMapper
import ru.depo.api.crash.type.CrashTypeMapper

object CrashMapper {
    fun toDto(entity: Crash): CrashDto =
            CrashDto(
                    id = entity.id,
                    description = entity.description,
                    crashType = CrashTypeMapper.toDto(entity = entity.crashType),
                    crashStatus = CrashStatusMapper.toDto(entity = entity.crashStatus),
                    cart = CartMapper.toDto(entity = entity.cart)
            )
}