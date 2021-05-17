package io.demo.productsearchapp.neo4j.utils


interface INeoSerializer {
    fun serialize(parameters: Map<String, Any?>): Map<String, Any?>
}