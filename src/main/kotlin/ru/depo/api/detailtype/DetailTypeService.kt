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
                                    amount = detailTypeDto.amount ?: throw UnsupportedEntityException("Количество деталей не задано")
                            )
                    )
            )

    fun delete(id: Long) =
            detailTypeRepository.deleteById(id)

    fun getOne(detailTypeId: Long) = detailTypeRepository.getOne(detailTypeId)
}