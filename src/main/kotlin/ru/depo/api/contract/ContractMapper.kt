package ru.depo.api.contract

import ru.depo.api.cart.Cart
import ru.depo.api.cart.CartMapper
import ru.depo.api.client.ClientMapper
import ru.depo.api.contract.status.ContractStatusDto
import ru.depo.api.contract.status.ContractStatusMapper
import ru.depo.api.manager.ManagerMapper

object ContractMapper {
    fun toDto(entity: Contract): ContractDto =
            ContractDto(
                    id = entity.id,
                    contractDate = entity.contractDate,
                    cost = entity.cost,
                    number = entity.number,
                    client = ClientMapper.toDto(entity.client),
                    manager = ManagerMapper.toDto(entity.manager),
                    status = ContractStatusMapper.toDto(entity.status),
                    carts = listOf()

            )

    fun toDtoWithCarts(entity: Contract, carts: Set<Cart>): ContractDto =
            ContractDto(
                    id = entity.id,
                    contractDate = entity.contractDate,
                    cost = entity.cost,
                    number = entity.number,
                    client = ClientMapper.toDto(entity.client),
                    manager = ManagerMapper.toDto(entity.manager),
                    status = ContractStatusMapper.toDto(entity.status),
                    carts = carts.map{ CartMapper.toDtoWithNumberOnly(it) }
            )
}