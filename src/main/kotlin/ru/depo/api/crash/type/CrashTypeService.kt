package ru.depo.api.crash.type

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class CrashTypeService(
        private val crashTypeRepository: CrashTypeRepository
) {
    fun getAll(): List<CrashTypeDto> =
            crashTypeRepository.findAll().map {
                CrashTypeMapper.toDto(it)
            }

    fun save(crashTypeDto: CrashTypeDto): CrashTypeDto =
            CrashTypeMapper.toDto(
                    crashTypeRepository.save(
                            CrashType(
                                    name = crashTypeDto.name
                                            ?: throw UnsupportedEntityException("Название типа поломки не задано"),
                                    description = crashTypeDto.description
                                            ?: throw UnsupportedEntityException("Описание типа поломки не задано"),
                                    cost = crashTypeDto.cost
                                            ?: throw UnsupportedEntityException("Цена типа поломки не задана")
                            )
                    )
            )

    fun delete(id: Long) =
            crashTypeRepository.deleteById(id)

    fun getOne(id: Long): CrashType =
            crashTypeRepository.getOne(id)
}