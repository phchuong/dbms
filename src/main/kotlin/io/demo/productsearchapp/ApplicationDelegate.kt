package io.demo.productsearchapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableNeo4jRepositories
class ApplicationDelegate

fun main(args: Array<String>) {
	runApplication<ApplicationDelegate>(*args)
}