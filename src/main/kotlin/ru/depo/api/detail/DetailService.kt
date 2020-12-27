package ru.depo.api.detail

import org.springframework.stereotype.Service
import ru.depo.api.cart.CartService
import ru.depo.api.detailtype.DetailTypeService
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class DetailService(
        private val detailRepository: DetailRepository,
        private val cartService: CartService,
        private val detailTypeService: DetailTypeService,
) {
    fun getAll(): List<DetailDto> =
            detailRepository.findAll().map {
                DetailMapper.toDto(it)
            }

    fun save(detailDto: DetailDto): DetailDto =
            DetailMapper.toDto(
                    detailRepository.save(
                            Detail(
                                    serialNumber = detailDto.serialNumber
                                            ?: throw UnsupportedEntityException("Серийный номер детали не задан"),
                                    detailType = detailTypeService.getOne(detailDto.detailType?.id
                                            ?: throw UnsupportedEntityException("УИД типа детали не задан")),
                                    cart = cartService.getOne(detailDto.cart?.id
                                            ?: throw UnsupportedEntityException("УИД типа вагона задан"))
                            )
                    )
            )

    fun delete(id: Long) = detailRepository.deleteById(id)
}