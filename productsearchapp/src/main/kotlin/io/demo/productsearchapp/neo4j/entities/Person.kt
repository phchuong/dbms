package io.demo.productsearchapp.neo4j.entities

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
class Person {
    @Id
    @GeneratedValue
    var id: Long? = null
    var name: String? = null
    var born = 0

    @Relationship(type = "ACTED_IN")
    private val movies: List<Movie>? = null // standard constructor, getters and setters
}