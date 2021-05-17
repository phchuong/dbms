package io.demo.productsearchapp.redis.repository

import io.demo.productsearchapp.redis.entities.Basket
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Basket, String>