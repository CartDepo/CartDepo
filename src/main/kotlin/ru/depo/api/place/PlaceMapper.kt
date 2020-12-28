package ru.depo.api.place

import ru.depo.api.place.status.PlaceStatusMapper
import ru.depo.api.place.type.PlaceTypeMapper

object PlaceMapper {
    fun toDto(entity: Place): PlaceDto =
            PlaceDto(
                    id = entity.id,
                    number = entity.number,
                    placeStatus = PlaceStatusMapper.toDto(entity.placeStatus),
                    placeType = PlaceTypeMapper.toDto(entity.placeType)
            )
}