package ru.depo.api.cart

object CartMapper {
    fun toDto(entity: Cart): CartDto =
            CartDto(
                    id = entity.id,
                    number = entity.number,
                    year = entity.year,
                    contract = entity.contract,
                    foreman = entity.foreman,
                    place = entity.place,
                    placeType = entity.placeType
            )
}