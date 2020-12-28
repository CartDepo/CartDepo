package ru.depo.api.place

import ru.depo.api.placeStatus.PlaceStatusDto
import ru.depo.api.placeType.PlaceTypeDto

class PlaceDto(
        val id: Long? = null,
        val number: String? = null,
        val placeType: PlaceTypeDto? = null,
        val placeStatus: PlaceStatusDto? = null
)