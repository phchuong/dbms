

package io.demo.productsearchapp
import org.springframework.web.bind.annotation.*

import io.demo.productsearchapp.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import org.springframework.web.bind.annotation.*


@Repository
interface UserRepository : MongoRepository<User, String>{

}

@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {
   
    @PostMapping("/login")
    fun payment(@RequestBody user: User): User {
        var res= User();
        if(user.password!="123456")
            return res;
        return user;
    }

	@GetMapping("/profile/{id}")
    fun getUser(@PathVariable id: Int): User {
        var res= User();
        return res;
    }
	
	
}

