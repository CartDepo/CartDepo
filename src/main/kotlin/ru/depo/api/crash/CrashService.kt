package ru.depo.api.crash

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.depo.api.cart.CartService
import ru.depo.api.crash.status.CrashStatusService
import ru.depo.api.crash.type.CrashTypeService
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class CrashService(
    private val crashRepository: CrashRepository,
    private val cartService: CartService,
    private val crashTypeService: CrashTypeService,
    private val crashStatusService: CrashStatusService,
) {
    fun getAll(): List<CrashDto> =
        crashRepository.findAll().map {
            CrashMapper.toDto(it)
        }

    fun save(crashDto: CrashDto): CrashDto =
        CrashMapper.toDto(
            crashRepository.save(
                Crash(
                    id = crashDto.id,
                    description = crashDto.description
                        ?: throw UnsupportedEntityException("Описание поломки не задано"),
                    crashType = crashTypeService.getOne(
                        crashDto.crashType?.id
                            ?: throw UnsupportedEntityException("УИД типа поломки не задан")
                    ),
                    crashStatus = crashStatusService.getOne(
                        crashDto.crashStatus?.id
                            ?: throw UnsupportedEntityException("УИД статуса поломки не задан")
                    ),
                    cart = cartService.getOne(
                        crashDto.cart?.id
                            ?: throw UnsupportedEntityException("УИД вагона задан")
                    )
                )
            )
        )

    fun delete(id: Long) = crashRepository.deleteById(id)

    fun addCrash(description: String, cartid: Long, typeid: Long, crashstatusid: Long) {
        crashRepository.addCrash(
            description = description,
            cartid = cartid,
            typeid = typeid,
            crashstatusid = crashstatusid
        )
    }

    fun changeStatus(crashId: Long, statusId: Long): CrashDto? {
        crashRepository.changeCrashStatus(crashId = crashId, statusId = statusId)

        return crashRepository.findByIdOrNull(crashId)?.let { CrashMapper.toDto(it) }
    }

    fun getOne(id: Long) = crashRepository.getOne(id)
}