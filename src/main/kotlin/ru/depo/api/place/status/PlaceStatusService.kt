package ru.depo.api.place.status

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

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
                    id = placeStatusDto.id,
                    name = placeStatusDto.name
                        ?: throw UnsupportedEntityException("Название статуса расположения не задан")
                )
            )
        )

    fun delete(id: Long) =
        placeStatusRepository.deleteById(id)

    fun getOne(id: Long): PlaceStatus =
        placeStatusRepository.getOne(id)
}