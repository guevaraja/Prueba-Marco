package eva_andres.demo.repository

import eva_andres.demo.model.asistente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository


interface asistenteRepository: JpaRepository <asistente, Long>{
}