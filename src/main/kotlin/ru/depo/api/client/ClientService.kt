package ru.depo.api.client

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class ClientService(
        private val clientRepository: ClientRepository
) {
    fun getAll(): List<ClientDto> =
            clientRepository.findAll().map {
                ClientMapper.toDto(it)
            }

    fun save(clientDto: ClientDto): ClientDto =
            ClientMapper.toDto(
                    clientRepository.save(
                            Client(
                                    fio = clientDto.fio  ?: throw UnsupportedEntityException("ФИО клиента расположения не задан"),
                                    serial = clientDto.serial  ?: throw UnsupportedEntityException("Серия паспорта клиента не задана"),
                                    number = clientDto.number  ?: throw UnsupportedEntityException("Номер паспорта клиента не задан"),
                                    phone = clientDto.phone  ?: throw UnsupportedEntityException("Телефон клиента не задан")
                            )
                    )
            )

    fun delete(clientDto: ClientDto) =
            clientRepository.deleteById(clientDto.id ?: throw UnsupportedEntityException("УИД клиента не задан"))
}