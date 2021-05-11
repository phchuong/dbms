//package io.pratik.elasticsearch.productsearchapp.controller
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//import io.pratik.elasticsearch.productsearchapp.document.Employee
//import io.pratik.elasticsearch.productsearchapp.repository.EmployeeRepository
//import io.pratik.elasticsearch.productsearchapp.repository.EmployeeRepository1
//import java.util.*
//
//@RestController
//@RequestMapping("/employees")
//class EmployeeController(val repository: EmployeeRepository, val repository1: EmployeeRepository1) {
////    @Autowired
////    lateinit var repository: EmployeeRepository
////    @GetMapping
////    fun getAll(): List<Employee> {
////        return repository.findAll().toList()
////    }
////
////    @PostMapping
////    fun add(@RequestBody employee: Employee): Employee {
////        return repository.save(employee)
////    }
////
////    @GetMapping("/{pos}")
////    fun findByName(@PathVariable("pos") pos: String): List<Employee> {
////        return repository1.findByPosition(pos)
////    }
//
////    @GetMapping
////    fun findById(@RequestParam id: Long): Optional<Employee> {
////        return repository.findById(id)
////    }
//
////    @GetMapping("/{name}")
////    fun findByName(@PathVariable("name") name: String): List<Employee> {
////        return repository.findByName(name)
////    }
//
////    @GetMapping("/organization/{organizationName}")
////    fun findByOrganizationName(@PathVariable("organizationName") organizationName: String): List<Employee> {
////        return repository.findByOrganizationName(organizationName)
////    }
//}
//
//
////
////    @GetMapping
////    fun getAll(): List<Person> {
////        return personRepository.findAll().toList()
////    }
////
////    @PostMapping
////    fun save(@RequestBody person: Person): Person {
////        personRepository.save(person)
////        return person
////    }
////
////    @PutMapping
////    fun updateNameById(@RequestParam id: String, @RequestParam name: String): Optional<Person> {
////        val person = personRepository.findById(id)
////        person.ifPresent {
////            it.name = name
////            personRepository.save(person.get())
////        }
////        return person
////    }