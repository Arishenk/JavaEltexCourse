package com.arishenk;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer integer);
}

