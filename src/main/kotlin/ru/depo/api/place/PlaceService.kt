package ru.depo.api.place

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.place.status.PlaceStatusService
import ru.depo.api.place.type.PlaceTypeService
import javax.persistence.EntityNotFoundException

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
                                    number = placeDto.number
                                            ?: throw UnsupportedEntityException("Название статуса расположения не задан"),
                                    placeType = placeTypeService.getOne(
                                            placeDto.placeType?.id
                                                    ?: throw UnsupportedEntityException("УИД типа расположения не задан")
                                    ),
                                    placeStatus = placeStatusService.getOne(
                                            placeDto.placeStatus?.id
                                                    ?: throw UnsupportedEntityException("УИД статуса расположения не задан")
                                    )
                            )
                    )
            )

    fun delete(id: Long) =
        placeRepository.deleteById(id)

    fun getOne(id: Long): Place =
            placeRepository.getOne(id)

    fun changePlaceStatus(placeId: Long, placeStatusId: Long): PlaceDto {
        placeRepository.changePlaceStatus(placeId, placeStatusId)
        return placeRepository.findByIdOrNull(placeId)?.let {
            PlaceMapper.toDto(it)
        } ?: throw EntityNotFoundException("Расположение c УИД=$placeId не найдено")
    }

    fun getPlaceByPlaceType(placeType: Long) =
            placeRepository.getPlaceByPlaceType(placeType).map(PlaceMapper::toDto)

    fun getPlaceByPlaceStatus(placeStatus: Long) = placeRepository.getPlaceByPlaceStatus(placeStatus)
            .map(PlaceMapper::toDto)
}