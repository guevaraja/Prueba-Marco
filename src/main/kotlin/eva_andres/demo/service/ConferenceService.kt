package eva_andres.demo.service

import eva_andres.demo.model.Conference
import eva_andres.demo.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list (pageable: Pageable,product:Conference):Page<Conference>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("brand"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return conferenceRepository.findAll(Example.of(product, matcher), pageable)
    }
    fun save(conference:Conference):Conference{
        return conferenceRepository.save(conference)

    }

    fun update(conference: Conference):Conference{
        try{
            conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")
            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateStock(conference:Conference):Conference{
        try{
            val response =  conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")
            response.apply {
                speaker =conference.speaker

            }
            return conferenceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}