package ru.depo.api.contract

import org.springframework.stereotype.Service
import ru.depo.api.client.ClientService
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.manager.ManagerService

@Service
class ContractService(
        private val contractRepository: ContractRepository,
        private val clientService: ClientService,
        private val managerService: ManagerService
) {
    fun getAll(): List<ContractDto> =
            contractRepository.findAll().map {
                ContractMapper.toDto(it)
            }

    fun save(contractDto: ContractDto): ContractDto =
            ContractMapper.toDto(
                    contractRepository.save(
                            Contract(
                                    contractDate = contractDto.contractDate
                                            ?: throw UnsupportedEntityException("Дата договора не задана"),
                                    cost = contractDto.cost
                                            ?: throw UnsupportedEntityException("Стоимость ремонта в договоре не задана"),
                                    number = contractDto.number
                                            ?: throw UnsupportedEntityException("Номер договора не задан"),
                                    client = clientService.getOne(
                                            contractDto.client?.id
                                                    ?: throw UnsupportedEntityException("УИД клиента в договоре не задан")
                                    ),
                                    manager = managerService.getOne(
                                            contractDto.manager?.id
                                                    ?: throw UnsupportedEntityException("УИД менеджера в договоре не задан")
                                    )
                            )
                    )
            )

    fun delete(id: Long) =
            contractRepository.deleteById(id)

    fun getOne(id: Long): Contract =
            contractRepository.getOne(id)
}