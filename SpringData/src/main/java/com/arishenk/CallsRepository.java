package com.arishenk;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CallsRepository extends MongoRepository<Calls, Integer> {
    List<Calls> findByTime(String time);
}
