package ru.depo.api.manager

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class ManagerService(
        private val managerRepository: ManagerRepository
) {
    fun getAll(): List<ManagerDto> =
            managerRepository.findAll().map {
                ManagerMapper.toDto(it)
            }

    fun save(managerDto: ManagerDto): ManagerDto =
            ManagerMapper.toDto(
                    managerRepository.save(
                            Manager(
                                    fio = managerDto.fio  ?: throw UnsupportedEntityException("ФИО менеджера не заданы"),
                                    phone = managerDto.phone  ?: throw UnsupportedEntityException("Номер телефона менеджера не задан")
                            )
                    )
            )

    fun delete(managerDto: ManagerDto) =
            managerRepository.delete(
                    managerRepository.getOne(managerDto.id ?: throw UnsupportedEntityException("УИД менеджера не задан"))
            )
}