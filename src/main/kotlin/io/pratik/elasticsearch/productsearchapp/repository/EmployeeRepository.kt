package io.pratik.elasticsearch.productsearchapp.repository

import io.pratik.elasticsearch.productsearchapp.document.Employee
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : ElasticsearchRepository<Employee, Long> {
    fun findByPosition(pos: String): List<Employee>
}

@Repository
interface EmployeeRepository1 : ElasticsearchRepository<Employee, Long> {
    fun findByPosition(pos: String): List<Employee>
}