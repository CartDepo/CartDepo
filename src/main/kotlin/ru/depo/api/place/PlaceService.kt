package ru.depo.api.place

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.placeStatus.PlaceStatusService
import ru.depo.api.placeType.PlaceTypeService

@Service
class PlaceService(
        private val placeRepository: PlaceRepository,
        private val placeStatusService: PlaceStatusService,
        private val placeTypeService: PlaceTypeService,
) {
    fun getAll(): List<PlaceDto> =
            placeRepository.findAll().map {
                PlaceMapper.toDto(it)
            }

    fun save(placeDto: PlaceDto): PlaceDto =
            PlaceMapper.toDto(
                    placeRepository.save(
                            Place(
                                    number = placeDto.number  ?: throw UnsupportedEntityException("Название статуса расположения не задан"),
                                    placeType = placeTypeService.getOne(
                                            placeDto.placeType?.id  ?: throw UnsupportedEntityException("УИД типа расположения не задан")
                                    ),
                                    placeStatus = placeStatusService.getOne(
                                            placeDto.placeStatus?.id  ?: throw UnsupportedEntityException("УИД статуса расположения не задан")
                                    )
                            )
                    )
            )

    fun delete(id: Long) =
            placeRepository.deleteById(id)

    fun getOne(id: Long): Place =
        placeRepository.getOne(id)
}