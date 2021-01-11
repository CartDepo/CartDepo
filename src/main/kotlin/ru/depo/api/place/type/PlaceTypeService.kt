package ru.depo.api.place.type

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class PlaceTypeService(
    private val placeTypeRepository: PlaceTypeRepository
) {
    fun getAll(): List<PlaceTypeDto> =
        placeTypeRepository.findAll().map {
            PlaceTypeMapper.toDto(it)
        }

    fun save(placeTypeDto: PlaceTypeDto): PlaceTypeDto =
        PlaceTypeMapper.toDto(
            placeTypeRepository.save(
                PlaceType(
                    id = placeTypeDto.id,
                    name = placeTypeDto.name
                        ?: throw UnsupportedEntityException("Название типа расположения не задан")
                )
            )
        )

    fun delete(id: Long) =
        placeTypeRepository.deleteById(id)

    fun getOne(id: Long): PlaceType =
        placeTypeRepository.getOne(id)
}