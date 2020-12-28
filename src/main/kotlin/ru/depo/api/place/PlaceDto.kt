package ru.depo.api.place

import ru.depo.api.place.status.PlaceStatusDto
import ru.depo.api.place.type.PlaceTypeDto

class PlaceDto(
        val id: Long? = null,
        val number: String? = null,
        val placeType: PlaceTypeDto? = null,
        val placeStatus: PlaceStatusDto? = null
)