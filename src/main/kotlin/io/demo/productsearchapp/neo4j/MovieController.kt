package io.demo.productsearchapp.neo4j

import io.demo.productsearchapp.neo4j.entities.Movie
import io.demo.productsearchapp.neo4j.entities.Person
import io.demo.productsearchapp.neo4j.entities.Role
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/movies")
class MovieController(val movieRepository: MovieRepository, val personRepository: PersonRepository) {
//    @Autowired
//    var movieRepositoryNew: UserRepository? = null

    @PostMapping("/make")
    fun makeDB(): Boolean {
        initializeDatabase()
        return true
    }

    @PostMapping("/makeSomeMovive")
    fun makeSomeMovie(): Boolean {
        makeSomeMovies()
        return true
    }

    @GetMapping("/find")
    fun find(title: String): Movie {
        val movie = movieRepository.findByTitle("The one")
        return movie
    }

    @GetMapping("/find1")
    fun find1(title: String): Collection<Movie>? {
        val movie = movieRepository.findByTitleContaining("The")
        return movie
    }

    @GetMapping("/find2")
    fun find2(title: String): List<Map<String, Object>> {
        val movie = movieRepository.graph(10)
        return movie
    }

    @GetMapping("/find3")
    fun find3(title: String): List<Map<String, Object>> {
        val movie = movieRepository.some(100)
        return movie
    }

    private fun makeSomeMovies() {
        val video1 = Movie()
        video1.title = "The one"
        video1.released = 1991

        val video2 = Movie()
        video2.title = "The two"
        video2.released = 1992

        movieRepository.save(video1)
        movieRepository.save(video2)
    }

    private fun initializeDatabase() {
        println("seeding embedded database")
        val italianJob = Movie()
        italianJob.title = "The Italian Job"
        italianJob.released = 1999
        movieRepository.save(italianJob)

        val mark = Person()
        mark.name = "Mark Wahlberg"
        personRepository.save(mark)

        val charlie = Role()
        charlie.movie = italianJob
        charlie.person = mark

        val roleNames: MutableCollection<String> = HashSet()
        roleNames.add("Charlie Croker")
        charlie.roles = roleNames

        val roles: MutableList<Role> = ArrayList()
        roles.add(charlie)
        charlie.roles = roleNames
        italianJob.roles = roles
        movieRepository.save(italianJob)
    }
}