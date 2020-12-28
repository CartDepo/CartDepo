package ru.depo.api.detail.type

object DetailTypeMapper {
    fun toDto(entity: DetailType): DetailTypeDto =
            DetailTypeDto(
                    id = entity.id,
                    name = entity.name,
                    amount = entity.amount
            )
}