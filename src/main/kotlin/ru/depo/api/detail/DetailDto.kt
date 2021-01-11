package ru.depo.api.detail

import ru.depo.api.cart.CartDto
import ru.depo.api.detail.type.DetailTypeDto

class DetailDto(
        val id: Long? = null,
        val serialNumber: String? = null,
        val detailType: DetailTypeDto? = null,
        val cart: CartDto? = null
)