package eva_andres.demo.controller


import eva_andres.demo.model.Conference
import eva_andres.demo.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/conference")
class ConferenceController {

    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list (conference:Conference, pageable: Pageable):ResponseEntity<*>{
        val response= conferenceService.list(pageable ,conference)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody conference: Conference):Conference{
        return conferenceService.save(conference)
    }

    @PutMapping
    fun update (@RequestBody conference: Conference): ResponseEntity<Conference>{
        return ResponseEntity(conferenceService.update(conference),HttpStatus.OK )
    }

    @PatchMapping
    fun updateStock (@RequestBody conference:Conference):ResponseEntity<Conference>{
        return ResponseEntity(conferenceService.updateStock(conference), HttpStatus.OK)
    }


}