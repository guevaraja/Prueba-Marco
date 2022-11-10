package eva_andres.demo.controller

import eva_andres.demo.model.asistente
import eva_andres.demo.service.asistenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/asistente")
class asistenteController {
    @Autowired

    lateinit var asistenteService: asistenteService

    @GetMapping
    fun list(): List<asistente> {
        return asistenteService.list()
    }

    @PostMapping
    fun save(@RequestBody asistente: asistente): asistente {
        return asistenteService.save(asistente)


    }
}