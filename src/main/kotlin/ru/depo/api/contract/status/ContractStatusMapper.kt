package ru.depo.api.contract.status

object ContractStatusMapper {
    fun toDto(entity: ContractStatus): ContractStatusDto =
            ContractStatusDto(
                    id = entity.id,
                    name = entity.name
            )
}