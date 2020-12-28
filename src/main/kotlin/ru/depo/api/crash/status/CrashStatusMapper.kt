package ru.depo.api.crash.status

object CrashStatusMapper {
    fun toDto(entity: CrashStatus): CrashStatusDto =
            CrashStatusDto(
                    id = entity.id,
                    name = entity.name,
            )
}