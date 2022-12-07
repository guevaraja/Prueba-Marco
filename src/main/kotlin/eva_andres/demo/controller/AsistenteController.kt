package eva_andres.demo.controller

import eva_andres.demo.model.Asistente
import eva_andres.demo.model.Invoice
import eva_andres.demo.service.AsistenteService
import eva_andres.demo.service.InvoiceService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/asistente")
class AsistenteController {

    @Autowired
    lateinit var asistenteService: AsistenteService

    @GetMapping
    fun list():List<Asistente>{
        return asistenteService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid asistente: Asistente):Asistente{
        return asistenteService.save(asistente)
    }

    @PutMapping
    fun update (@RequestBody asistente: Asistente): ResponseEntity<Asistente>{
        return ResponseEntity(asistenteService.update(asistente),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody asistente:Asistente):ResponseEntity<Asistente>{
        return ResponseEntity(asistenteService.updateName(asistente), HttpStatus.OK)
    }

}