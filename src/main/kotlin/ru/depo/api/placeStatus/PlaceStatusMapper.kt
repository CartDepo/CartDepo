package ru.depo.api.placeStatus

object PlaceStatusMapper {
    fun toDto(entity: PlaceStatus): PlaceStatusDto =
            PlaceStatusDto(
                    id = entity.id,
                    name = entity.name,
            )
}