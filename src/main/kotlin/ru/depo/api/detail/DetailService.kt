package ru.depo.api.detail

import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import ru.depo.api.cart.CartService
import ru.depo.api.detail.type.DetailTypeService
import ru.depo.api.exeption.UnsupportedEntityException
import javax.persistence.EntityNotFoundException

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

    fun addDetailToCart(detailTypeId: Long, cartId: Long, serialNumber: String): DetailDto {
        detailRepository.addDetailToCart(detailTypeId, cartId, serialNumber)
        return detailRepository.findByIdOrNull(detailTypeId)?.let {
            DetailMapper.toDto(it)
        } ?: throw EntityNotFoundException("Деталь с УИД=$detailTypeId не найдена")
    }
}