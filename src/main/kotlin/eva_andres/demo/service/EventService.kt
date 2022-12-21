package eva_andres.demo.service

import eva_andres.demo.model.Member
import eva_andres.demo.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AsistenteService {

    @Autowired
    lateinit var asistenteRepository: MemberRepository

    fun list():List<Member>{
        return asistenteRepository.findAll()
    }

    fun listById (id: Long?): Member{
        return asistenteRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        asistenteRepository.findById(id) ?:
        throw  Exception()
        asistenteRepository.deleteById(id!!)
        return true
    }

    fun save(asistente:Member):Member{
        return asistenteRepository.save(asistente)

    }

    fun update(asistente: Member):Member{
        try{
            asistenteRepository.findById(asistente.id)
                ?: throw Exception("ID no existe")
            return asistenteRepository.save(asistente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(asistente:Member): Member{
        try{
            val response = asistenteRepository.findById(asistente.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombres=asistente.nombres

            }
            return asistenteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}