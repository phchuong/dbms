package io.demo.productsearchapp.entities


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Document("User")
data class User (
    @Id
    val id: Int=-1,
    var username: String = "",
    var password: String = "",
    var name: String = "",
    var avatar: String = ""
){
	override fun toString(): String{
		val mapper = ObjectMapper()
		mapper.enable(SerializationFeature.INDENT_OUTPUT)
		val jsonString = mapper.writeValueAsString(this)
		return jsonString 
	}
}