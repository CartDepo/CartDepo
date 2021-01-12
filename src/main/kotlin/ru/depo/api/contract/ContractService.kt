package ru.depo.api.contract

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.depo.api.cart.CartDto
import ru.depo.api.cart.CartMapper
import ru.depo.api.cart.CartRepository
import ru.depo.api.client.ClientService
import ru.depo.api.contract.status.ContractStatusService
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.manager.ManagerService
import java.time.LocalDate
import javax.persistence.EntityNotFoundException

@Service
class ContractService(
    private val contractRepository: ContractRepository,
    private val clientService: ClientService,
    private val managerService: ManagerService,
    private val contractStatusService: ContractStatusService,
    private val cartRepository: CartRepository
) {
    fun getAll(): List<ContractDto> =
        contractRepository.findAll().map {
            ContractMapper.toDto(it)
        }

    fun save(contractDto: ContractDto): ContractDto =
        ContractMapper.toDto(
            contractRepository.save(
                Contract(
                    id = contractDto.id,
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
                    ),
                    status = contractStatusService.getOne(
                        contractDto.status?.id
                            ?: throw UnsupportedEntityException("УИД статуса договора не задан")
                    )
                )
            )
        )

    fun delete(id: Long) =
        contractRepository.deleteById(id)

    fun getOne(id: Long): Contract =
        contractRepository.getOne(id)

    fun addContract(
        contractDate: String,
        cost: Long,
        number: String,
        clientid: Long,
        managerid: Long
    ) {
        contractRepository.addContract(
            contractdate = LocalDate.parse(contractDate),
            cost = cost,
            number = number,
            clientid = clientid,
            managerid = managerid,
            contractstatusid = 1,
        )
    }

    fun findById(id: Long): ContractDto =
            contractRepository.findByIdOrNull(id)?.let {
                ContractMapper.toDtoWithCarts(it, cartRepository.findByContractId(id))
            } ?: throw EntityNotFoundException("Не найден договор с УИД=$id")
}