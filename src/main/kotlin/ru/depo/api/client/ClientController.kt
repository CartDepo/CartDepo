package ru.depo.api.client

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("client")
class ClientController(
        private val clientService: ClientService
) {
    @GetMapping("all")
    fun getAll(): List<ClientDto> =
            clientService.getAll()

    @PostMapping("save")
    fun save(@RequestBody clientDto: ClientDto): ClientDto =
            clientService.save(clientDto = clientDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            clientService.delete(id = id)

    @GetMapping("add")
    fun addClient(@RequestBody clientDto: ClientDto) {
        clientService.addClient(clientDto = clientDto)
    }
}