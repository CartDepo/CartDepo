package ru.depo.api.foreman

object ForemanMapper {
    fun toDto(entity: Foreman): ForemanDto =
            ForemanDto(
                    id = entity.id,
                    fio = entity.fio,
                    phone = entity.phone
            )
}