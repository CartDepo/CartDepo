package ru.depo.api.crash.type

object CrashTypeMapper {
    fun toDto(entity: CrashType): CrashTypeDto =
            CrashTypeDto(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description,
                    cost = entity.cost,
            )
}