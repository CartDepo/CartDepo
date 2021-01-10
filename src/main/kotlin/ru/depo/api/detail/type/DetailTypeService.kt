package ru.depo.api.detail.type

import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import javax.persistence.EntityNotFoundException

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
                                    name = detailTypeDto.name
                                            ?: throw UnsupportedEntityException("Название детали не задано"),
                                    amount = detailTypeDto.amount
                                            ?: throw UnsupportedEntityException("Количество деталей не задано")
                            )
                    )
            )

    fun delete(id: Long) =
            detailTypeRepository.deleteById(id)

    fun getOne(detailTypeId: Long) = detailTypeRepository.getOne(detailTypeId)

    fun addDetail(detailTypeId: Long, amount: Long): DetailTypeDto {
        detailTypeRepository.addDetail(detailTypeId, amount)
        return detailTypeRepository.findByIdOrNull(detailTypeId)?.let {DetailTypeMapper.toDto(it)} ?: throw EntityNotFoundException("Деталь с УИД=$detailTypeId не найдена")
    }

}