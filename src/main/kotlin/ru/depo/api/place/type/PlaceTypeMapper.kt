package ru.depo.api.place.type

object PlaceTypeMapper {
    fun toDto(entity: PlaceType): PlaceTypeDto =
            PlaceTypeDto(
                    id = entity.id,
                    name = entity.name,
            )
}