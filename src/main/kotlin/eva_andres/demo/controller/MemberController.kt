package eva_andres.demo.controller

import eva_andres.demo.model.Member
import eva_andres.demo.service.MemberService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/member")
class MemberController {

    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun list():List<Member>{
        return memberService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Member>{
        return ResponseEntity(memberService.listById(id), HttpStatus.OK)
    }


    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return memberService.delete(id)
    }

    @PostMapping
    fun save(@RequestBody @Valid member: Member):Member{
        return memberService.save(member)
    }

    @PutMapping
    fun update (@RequestBody member: Member): ResponseEntity<Member>{
        return ResponseEntity(memberService.update(member),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody member:Member):ResponseEntity<Member>{
        return ResponseEntity(memberService.updateName(member), HttpStatus.OK)
    }

}