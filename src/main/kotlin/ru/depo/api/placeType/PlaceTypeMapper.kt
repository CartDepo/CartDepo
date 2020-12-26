package ru.depo.api.placeType

object PlaceTypeMapper {
    fun toDto(entity: PlaceType): PlaceTypeDto =
            PlaceTypeDto(
                    id = entity.id,
                    name = entity.name,
            )
}