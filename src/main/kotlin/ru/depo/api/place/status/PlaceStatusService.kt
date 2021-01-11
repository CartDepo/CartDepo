package ru.depo.api.place.status

import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.place.PlaceDto
import ru.depo.api.place.PlaceMapper
import javax.persistence.EntityNotFoundException

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