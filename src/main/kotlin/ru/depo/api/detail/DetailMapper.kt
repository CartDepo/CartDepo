package ru.depo.api.detail

import ru.depo.api.cart.CartDto
import ru.depo.api.cart.CartMapper
import ru.depo.api.detailtype.DetailType
import ru.depo.api.detailtype.DetailTypeDto
import ru.depo.api.detailtype.DetailTypeMapper

object DetailMapper {
    fun toDto(entity: Detail): DetailDto =
            DetailDto(
                    id = entity.id,
                    serialNumber = entity.serialNumber,
                    detailType = DetailTypeMapper.toDto(entity = entity.detailType),
                    cart = CartMapper.toDto(entity = entity.cart)
            )
}