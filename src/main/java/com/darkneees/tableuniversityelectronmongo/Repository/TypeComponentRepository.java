package com.darkneees.tableuniversityelectronmongo.Repository;

import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeComponentRepository extends MongoRepository<TypeComponent, String> {

    @Query("{'value' : ?0}")
    Optional<TypeComponent> findByValue(String value);
}
