package ru.depo.api.client

object ClientMapper {
    fun toDto(entity: Client): ClientDto =
            ClientDto(
                    id = entity.id,
                    fio = entity.fio,
                    serial = entity.serial,
                    number = entity.number,
                    phone = entity.phone,
            )
}