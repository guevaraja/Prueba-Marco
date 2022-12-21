package eva_andres.demo.service

import eva_andres.demo.model.Invoice
import eva_andres.demo.repository.MemberRepository
import eva_andres.demo.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var asistenteRepository: MemberRepository
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list():List<Invoice>{
        return invoiceRepository.findAll()
    }
    fun listTotalMoreThan(total:Double?): List<Invoice>? {
        return invoiceRepository.findTotalMoreThan(total)
    }

    fun save(invoice:Invoice):Invoice{
        try{
            asistenteRepository.findById(invoice.asistenteId)
                ?: throw Exception("asistente no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }





    fun update(invoice: Invoice):Invoice{
        try{
            invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateTotal(invoice: Invoice): Invoice {
        try{
            val response = invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")
            response.apply {
                total=invoice.total
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}