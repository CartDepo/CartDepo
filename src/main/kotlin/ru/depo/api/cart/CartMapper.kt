package ru.depo.api.cart

import ru.depo.api.contract.ContractMapper
import ru.depo.api.foreman.ForemanMapper
import ru.depo.api.place.PlaceMapper
import ru.depo.api.place.type.PlaceTypeMapper

object CartMapper {
    fun toDto(entity: Cart): CartDto =
            CartDto(
                    id = entity.id,
                    number = entity.number,
                    year = entity.year,
                    contract = ContractMapper.toDto(entity.contract),
                    foreman = ForemanMapper.toDto(entity.foreman),
                    place = PlaceMapper.toDto(entity.place),
                    placeType = PlaceTypeMapper.toDto(entity.placeType)
            )
}