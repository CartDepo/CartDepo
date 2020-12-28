package ru.depo.api.place.status

object PlaceStatusMapper {
    fun toDto(entity: PlaceStatus): PlaceStatusDto =
            PlaceStatusDto(
                    id = entity.id,
                    name = entity.name,
            )
}