package io.demo.productsearchapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@SpringBootApplication
@EnableElasticsearchRepositories
class ApplicationDelegate

fun main(args: Array<String>) {
	runApplication<ApplicationDelegate>(*args)
}