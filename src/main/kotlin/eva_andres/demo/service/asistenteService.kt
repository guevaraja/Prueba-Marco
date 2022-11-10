package eva_andres.demo.service

import eva_andres.demo.model.asistente
import eva_andres.demo.repository.asistenteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class asistenteService {
    @Autowired
    lateinit var asistenteRepository: asistenteRepository
    fun list(): List<asistente>{
        return asistenteRepository.findAll()
    }
    fun save(asistente:asistente): asistente{
        return asistenteRepository.save(asistente)
    }
}