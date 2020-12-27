package ru.depo.api.detail

import ru.depo.api.cart.CartDto
import ru.depo.api.detailtype.DetailTypeDto

class DetailDto(
        val id: Long?,
        val serialNumber: String?,
        val detailType: DetailTypeDto?,
        val cart: CartDto?
)