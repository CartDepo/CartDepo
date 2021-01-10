package ru.depo.api.foreman

import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class ForemanService(
        private val foremanRepository: ForemanRepository
) {
    fun getAll(): List<ForemanDto> =
            foremanRepository.findAll().map {
                ForemanMapper.toDto(it)
            }

    fun save(foremanDto: ForemanDto): ForemanDto =
            ForemanMapper.toDto(
                    foremanRepository.save(
                            Foreman(
                                    fio = foremanDto.fio ?: throw UnsupportedEntityException("ФИО бригадира не заданы"),
                                    phone = foremanDto.phone
                                            ?: throw UnsupportedEntityException("Номер бригадира не задан")
                            )
                    )
            )

    fun delete(id: Long) =
            foremanRepository.deleteById(id)

    fun getOne(id: Long) =
            foremanRepository.getOne(id)
}