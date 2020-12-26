package ru.depo.api.manager

object ManagerMapper {
    fun toDto(entity: Manager): ManagerDto =
            ManagerDto(
                    id = entity.id,
                    fio = entity.fio,
                    phone = entity.phone
            )
}