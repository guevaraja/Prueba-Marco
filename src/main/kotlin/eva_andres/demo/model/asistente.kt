package eva_andres.demo.model

import javax.persistence.*

@Entity
@Table(name= "asistente")
class asistente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var email: String? = null
    var institucion: String? = null
    var cargo: String? = null
}