package ru.depo.api.exeption

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class UnsupportedEntityException(message: String?) : RuntimeException(message) {
}