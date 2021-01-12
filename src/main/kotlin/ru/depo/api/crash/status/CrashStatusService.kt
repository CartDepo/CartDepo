package ru.depo.api.crash.status

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class CrashStatusService(
    private val crashStatusRepository: CrashStatusRepository
) {
    fun getAll(): List<CrashStatusDto> =
        crashStatusRepository.findAll().map {
            CrashStatusMapper.toDto(it)
        }

    fun save(crashStatusDto: CrashStatusDto): CrashStatusDto =
        CrashStatusMapper.toDto(
            crashStatusRepository.save(
                CrashStatus(
                    id = crashStatusDto.id,
                    name = crashStatusDto.name
                        ?: throw UnsupportedEntityException("Название статуса поломки не задан")
                )
            )
        )

    fun delete(id: Long) =
        crashStatusRepository.deleteById(id)

    fun getOne(id: Long): CrashStatus =
        crashStatusRepository.getOne(id)
}