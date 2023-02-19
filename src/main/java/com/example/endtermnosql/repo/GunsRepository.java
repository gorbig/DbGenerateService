package com.example.endtermnosql.repo;

import com.example.endtermnosql.model.Gun;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GunsRepository extends MongoRepository<Gun, Long> {
}
