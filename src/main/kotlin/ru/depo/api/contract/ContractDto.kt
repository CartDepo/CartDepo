package ru.depo.api.contract

import com.fasterxml.jackson.annotation.JsonFormat
import ru.depo.api.cart.CartDto
import ru.depo.api.client.ClientDto
import ru.depo.api.contract.status.ContractStatusDto
import ru.depo.api.manager.ManagerDto
import java.math.BigDecimal
import java.time.LocalDate

class ContractDto(
        val id: Long? = null,
        @JsonFormat(pattern = "yyyy-MM-dd")
        val contractDate: LocalDate? = null,
        val cost: BigDecimal? = null,
        val number: String? = null,
        val client: ClientDto? = null,
        val manager: ManagerDto? = null,
        val status: ContractStatusDto? = null,
        val carts: List<CartDto>
)