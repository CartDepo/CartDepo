package ru.depo.api.cart

import ru.depo.api.contract.ContractDto
import ru.depo.api.foreman.ForemanDto
import ru.depo.api.place.PlaceDto
import ru.depo.api.place.type.PlaceTypeDto

data class CartDto(
        val id: Long? = null,
        val number: String? = null,
        val year: Int? = null,
        val contract: ContractDto? = null,
        val foreman: ForemanDto? = null,
        val place: PlaceDto? = null,
        val placeType: PlaceTypeDto? = null
)