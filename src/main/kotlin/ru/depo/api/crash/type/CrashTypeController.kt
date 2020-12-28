package ru.depo.api.crash.type

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("crash-type")
class CrashTypeController(
        private val crashTypeService: CrashTypeService
) {
    @GetMapping("all")
    fun getAll(): List<CrashTypeDto> =
            crashTypeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody crashTypeDto: CrashTypeDto): CrashTypeDto =
            crashTypeService.save(crashTypeDto = crashTypeDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            crashTypeService.delete(id = id)

}