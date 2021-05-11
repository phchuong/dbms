package io.pratik.elasticsearch.productsearchapp

import io.pratik.elasticsearch.productsearchapp.document.Department
import io.pratik.elasticsearch.productsearchapp.document.Employee
import io.pratik.elasticsearch.productsearchapp.document.Organization
import io.pratik.elasticsearch.productsearchapp.repository.EmployeeRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ProductsearchappApplicationTests(val repository: EmployeeRepository) {

	@Test
	fun contextLoads() {
	}
}
