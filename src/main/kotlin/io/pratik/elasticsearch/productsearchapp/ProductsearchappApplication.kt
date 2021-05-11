package io.pratik.elasticsearch.productsearchapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@SpringBootApplication
@EnableElasticsearchRepositories
class ProductsearchappApplication

fun main(args: Array<String>) {
	runApplication<ProductsearchappApplication>(*args)
}