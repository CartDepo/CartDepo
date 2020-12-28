package ru.depo.api.place

import ru.depo.api.placeStatus.PlaceStatusMapper
import ru.depo.api.placeType.PlaceTypeMapper

object PlaceMapper {
    fun toDto(entity: Place): PlaceDto =
            PlaceDto(
                    id = entity.id,
                    number = entity.number,
                    placeStatus = PlaceStatusMapper.toDto(entity.placeStatus),
                    placeType = PlaceTypeMapper.toDto(entity.placeType)
            )
}