package ru.depo.api.crash

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
                                    description = crashDto.description
                                            ?: throw UnsupportedEntityException("Описание поломки не задано"),
                                    crashType = crashTypeService.getOne(crashDto.crashType?.id
                                            ?: throw UnsupportedEntityException("УИД типа поломки не задан")),
                                    crashStatus = crashStatusService.getOne(crashDto.crashStatus?.id
                                            ?: throw UnsupportedEntityException("УИД статуса поломки не задан")),
                                    cart = cartService.getOne(crashDto.cart?.id
                                            ?: throw UnsupportedEntityException("УИД вагона задан"))
                            )
                    )
            )

    fun delete(id: Long) = crashRepository.deleteById(id)
}