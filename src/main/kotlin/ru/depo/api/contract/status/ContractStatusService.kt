package ru.depo.api.contract.status

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class ContractStatusService(
        private val contractStatusRepository: ContractStatusRepository,
) {
    fun getAll(): List<ContractStatusDto> =
            contractStatusRepository.findAll().map {
                ContractStatusMapper.toDto(it)
            }

    fun save(contractStatusDto: ContractStatusDto): ContractStatusDto =
            ContractStatusMapper.toDto(
                    contractStatusRepository.save(
                            ContractStatus(
                                    name = contractStatusDto.name
                                            ?: throw UnsupportedEntityException("Не указано имя статуса договора")
                            )
                    )
            )

    fun delete(id: Long) =
            contractStatusRepository.deleteById(id)

    fun getOne(id: Long): ContractStatus =
            contractStatusRepository.getOne(id)
}