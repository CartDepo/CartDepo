package ru.depo.api.cart

import ru.depo.api.contract.ContractMapper
import ru.depo.api.crash.Crash
import ru.depo.api.crash.CrashDto
import ru.depo.api.crash.CrashMapper
import ru.depo.api.foreman.ForemanMapper
import ru.depo.api.place.PlaceMapper
import ru.depo.api.place.type.PlaceTypeMapper
import ru.depo.api.team.TeamMapper

object CartMapper {
    fun toDto(entity: Cart): CartDto =
            CartDto(
                    id = entity.id,
                    number = entity.number,
                    year = entity.year,
                    contract = ContractMapper.toDto(entity.contract),
                    team = entity.team?.let { TeamMapper.toDto(it) } ,
                    place = PlaceMapper.toDto(entity.place)
            )

    fun toDtoWithCrashes(entity: Cart, crashes: Set<Crash>): CartDto =
            CartDto(
                    id = entity.id,
                    number = entity.number,
                    year = entity.year,
                    contract = ContractMapper.toDto(entity.contract),
                    team = entity.team?.let { TeamMapper.toDto(it) } ,
                    place = PlaceMapper.toDto(entity.place),
                    crashes = crashes.map { CrashMapper.toDtoWithoutCart(it) }
            )

    fun toDtoWithNumberOnly(entity: Cart): CartDto =
            CartDto(
                    id = entity.id,
                    number = entity.number,
                    year = entity.year,
            )
}