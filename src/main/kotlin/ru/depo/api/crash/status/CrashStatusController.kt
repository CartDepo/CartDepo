package ru.depo.api.crash.status

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("crash-status")
class CrashStatusController(
        private val crashStatusService: CrashStatusService
) {
    @GetMapping("all")
    fun getAll(): List<CrashStatusDto> =
            crashStatusService.getAll()

    @PostMapping("save")
    fun save(@RequestBody crashStatusDto: CrashStatusDto): CrashStatusDto =
            crashStatusService.save(crashStatusDto = crashStatusDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            crashStatusService.delete(id = id)
}