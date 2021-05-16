package io.demo.productsearchapp.neo4j.entities

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
class Movie {
    @Id
    @GeneratedValue
    var id: Long? = null
    var title: String? = null
    var released = 0
    var tagline: String? = null

    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    var roles: List<Role>? = null // standard constructor, getters and setters
}