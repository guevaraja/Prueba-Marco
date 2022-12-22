package eva_andres.demo.service

import eva_andres.demo.model.Register
import eva_andres.demo.repository.MemberRepository
import eva_andres.demo.repository.RegisterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RegisterService {
    @Autowired
    lateinit var registerepository: MemberRepository
    @Autowired
    lateinit var registerRepository: RegisterRepository

    fun list():List<Register>{
        return registerRepository.findAll()
    }
    fun listTotalMoreThan(total:Double?): List<Register>? {
        return registerRepository.findTotalMoreThan(total)
    }

    fun save(register:Register):Register{
        try{
            registerRepository.findById(register.memberId)
                ?: throw Exception("asistente no existe")
            return registerRepository.save(register)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }





    fun update(register: Register):Register{
        try{
            registerRepository.findById(register.id)
                ?: throw Exception("ID no existe")
            return registerRepository.save(register)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateTotal(register: Register): Register {
        try{
            val response = registerRepository.findById(register.id)
                ?: throw Exception("ID no existe")
            response.apply {
                code=register.code
            }
            return registerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun calculateAndUpdateTotal (register: Register){
        val totalCalculated = registerRepository.sumTotal(register.memberId)
        val conferenceResponse = conferenceRepository.findById(register.memberId)
        conferenceResponse.apply {
            totalAttendees=totalCalculated
        }
        conferenceRepository.save(conferenceResponse)
    }


}