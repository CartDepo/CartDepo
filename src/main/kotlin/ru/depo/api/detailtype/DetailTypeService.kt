package ru.depo.api.detailtype

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class DetailTypeService(
        private val detailTypeRepository: DetailTypeRepository
) {
    fun getAll(): List<DetailTypeDto> =
            detailTypeRepository.findAll().map {
                DetailTypeMapper.toDto(it)
            }

    fun save(detailTypeDto: DetailTypeDto): DetailTypeDto =
            DetailTypeMapper.toDto(
                    detailTypeRepository.save(
                            DetailType(
                                    name = detailTypeDto.name ?: throw UnsupportedEntityException("Название детали не задано"),
                                    number = detailTypeDto.number ?: throw UnsupportedEntityException("Номер детали не задан")
                            )
                    )
            )

    fun delete(detailTypeDto: DetailTypeDto) =
            detailTypeRepository.delete(
                    detailTypeRepository.getOne(detailTypeDto.id ?: throw UnsupportedEntityException("УИД типа расположения не задан"))
            )
}