package com.nelioalves.springbootMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.springbootMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
