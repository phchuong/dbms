package io.demo.productsearchapp.neo4j.utils

import org.neo4j.driver.AuthTokens
import org.neo4j.driver.Config
import org.neo4j.driver.Driver
import org.neo4j.driver.GraphDatabase
import org.neo4j.driver.internal.InternalRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


class NeoQuery(private val driver: Driver, private val serializer: INeoSerializer) {
    fun submit(query: String, parameters: Map<String, Any?> = mapOf()): CursorWrapper {
        val session = driver.session()

        return session.use {
            val parameters = serializer.serialize(parameters)
            val statementResult = session.run(query, parameters)
            if (statementResult.hasNext()) {
                CursorWrapper(statementResult.peek(), statementResult)
            } else {
                CursorWrapper(InternalRecord(listOf(), arrayOf()), statementResult)
            }
        }
    }
}

//@Component
//class Neo4jBoltCypherExecutor: CypherExecutor {
//    @Value("\${neo4j.bolt.url}")
//    private val boltUrl: String? = null
//
//    @Value("\${neo4j.bolt.user}")
//    private val user: String? = null
//
//    @Value("\${neo4j.bolt.pass}")
//    private val pass: String? = null
//    private var neo4jDriver: Driver? = null
//    @PostConstruct
//    fun postConstruct() {
//        val token = if (pass != null && pass.isNotEmpty()) AuthTokens.basic(user, pass) else AuthTokens.none()
//        neo4jDriver = GraphDatabase.driver(boltUrl, token, Config.builder().build())
//    }
//
//    fun run(query: String?, params: Map<String?, Any?>?): List<Map<String, Any>> {
//        neo4jDriver!!.session().use { session ->
//            return session.run(query, params).list { record ->
//                record.asMap { value -> convert(value) }
//            }
//        }
//    }
//
//    companion object {
//        private fun convert(value: Value): Any {
//            when (value.type().name()) {
//                "PATH" -> return value.asList({ value: Value? -> convert(value) })
//                "NODE", "RELATIONSHIP" -> return value.asMap()
//            }
//            return value.asObject()
//        }
//    }
//}