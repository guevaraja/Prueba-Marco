package eva_andres.demo.service

import eva_andres.demo.model.Event
import eva_andres.demo.model.Member
import eva_andres.demo.repository.EventRepository
import eva_andres.demo.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EventService {

    @Autowired
    lateinit var eventRepository: EventRepository

    fun list():List<Event>{
        return eventRepository.findAll()
    }

    fun listById (id: Long?): Event{
        return eventRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        eventRepository.findById(id) ?:
        throw  Exception()
        eventRepository.deleteById(id!!)
        return true
    }

    fun save(event: Event):Event{
        return eventRepository.save(event)

    }

    fun update(event: Event):Event{
        try{
            eventRepository.findById(event.id)
                ?: throw Exception("ID no existe")
            return eventRepository.save(event)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(event:Event): Event{
        try{
            val response = eventRepository.findById(event.id)
                ?: throw Exception("ID no existe")
            response.apply {
                totalAttendees=event.totalAttendees

            }
            return eventRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}