package io.demo.productsearchapp.neo4j.entities

import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "ACTED_IN")
class Role {
    @Id
    @GeneratedValue
    var id: Long? = null
    var roles: Collection<String>? = null

    @StartNode
    var person: Person? = null

    @EndNode
    var movie: Movie? = null // standard constructor, getters and setters
}