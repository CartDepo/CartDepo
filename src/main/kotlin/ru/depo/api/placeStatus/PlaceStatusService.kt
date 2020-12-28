package ru.depo.api.placeStatus

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.placeType.PlaceType

@Service
class PlaceStatusService(
        private val placeStatusRepository: PlaceStatusRepository
) {
    fun getAll(): List<PlaceStatusDto> =
            placeStatusRepository.findAll().map {
                PlaceStatusMapper.toDto(it)
            }

    fun save(placeStatusDto: PlaceStatusDto): PlaceStatusDto =
            PlaceStatusMapper.toDto(
                    placeStatusRepository.save(
                            PlaceStatus(
                                    name = placeStatusDto.name  ?: throw UnsupportedEntityException("Название статуса расположения не задан")
                            )
                    )
            )

    fun delete(id: Long) =
            placeStatusRepository.deleteById(id)

    fun getOne(id: Long): PlaceStatus =
            placeStatusRepository.getOne(id)
}