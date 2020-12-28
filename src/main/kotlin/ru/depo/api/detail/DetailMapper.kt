package ru.depo.api.detail

import ru.depo.api.cart.CartMapper
import ru.depo.api.detail.type.DetailTypeMapper

object DetailMapper {
    fun toDto(entity: Detail): DetailDto =
            DetailDto(
                    id = entity.id,
                    serialNumber = entity.serialNumber,
                    detailType = DetailTypeMapper.toDto(entity = entity.detailType),
                    cart = CartMapper.toDto(entity = entity.cart)
            )
}