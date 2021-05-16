package io.demo.productsearchapp.neo4j

import io.demo.productsearchapp.neo4j.entities.Movie
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository: Neo4jRepository<Movie, Long> {
    fun findByTitle(@Param("title") title: String): Movie

    @Query("MATCH (m:Movie) WHERE m.title =~ ('(?i).*'+{title}+'.*') RETURN m")
    fun findByTitleContaining(@Param("title") title: String): Collection<Movie>

    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.name) as cast LIMIT {limit}")
    fun graph(@Param("limit") limit: Int): List<Map<String,Object>>

    @Query("MATCH (tom:Person {name: \"Tom Hanks\"})-[:ACTED_IN]->(tomHanksMovies) RETURN tom,tomHanksMovies")
    fun some(@Param("limit") limit: Int): List<Map<String,Object>>
}

//@Component
//class PersonRepositoryImpl: PersonRepository {
//    private var logger = LoggerFactory.getLogger(UserRepositoryImpl::class.java)
//    private val driver = GraphDatabase.driver(
//        "bolt://localhost:7687",
//        AuthTokens.basic("neo4j", "secret")
//        , Config.builder().withLogging(NeoLogging(logger)).build()
//    )
//    private val neo = NeoQuery(driver, DefaultNeoSerializer())
//
//    override fun findByTitleContaining(title: String): Collection<Movie> {
//        val query = "MATCH (m:Movie) WHERE m.title =~ ('(?i).*${title}.*') RETURN m"
//        val listMovie = cypherResult("MATCH (m:Movie) WHERE m.title =~ ('(?i).*${title}.*') RETURN m")
//
//        return Collections.unmodifiableCollection(listMovie)
//    }
//
//    fun cypherResult(query: String): Collection<Movie>? {
//        val mapper = Function<Record, Movie> { record ->
//            val title = record.get("m").asNode().get("title").asString()
//            val tagline = record.get("m").asNode().get("tagline").asString()
//            val movie = Movie()
//            movie.title = title
//            movie.tagline = tagline
//            movie
//        }
//
//        return  readCyphers<Movie>(driver, query, mapper)
//    }
//
//    fun <T>readCyphers(driver: Driver, cypher: String?, mapper: java.util.function.Function<Record, T>): List<T>? {
//        driver.use { driver ->
//            driver.session().use { session ->
//                val result = session.run(cypher)
//                return result.list(mapper)
//            }
//        }
//    }
//}