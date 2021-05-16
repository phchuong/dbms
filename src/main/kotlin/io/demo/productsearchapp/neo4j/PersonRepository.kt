package io.demo.productsearchapp.neo4j

import io.demo.productsearchapp.neo4j.entities.Person
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : Neo4jRepository<Person?, Long?> { //
}
