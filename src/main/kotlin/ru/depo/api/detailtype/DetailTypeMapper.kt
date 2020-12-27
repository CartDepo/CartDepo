package ru.depo.api.detailtype

object DetailTypeMapper {
    fun toDto(entity: DetailType): DetailTypeDto =
            DetailTypeDto(
                    id = entity.id,
                    name = entity.name,
                    amount = entity.amount
            )
}