package com.nelioalves.springbootMongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nelioalves.springbootMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

		@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
		List<Post> searchTitle(String text);
	
		List<Post> findByTitleContainingIgnoreCase(String texto);
		
		@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
		List<Post> fullSearch(String text, Date minDate, Date maxDate);
		
}
