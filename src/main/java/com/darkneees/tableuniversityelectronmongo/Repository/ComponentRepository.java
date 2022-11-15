package com.darkneees.tableuniversityelectronmongo.Repository;

import com.darkneees.tableuniversityelectronmongo.Entity.Component;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends MongoRepository<Component, String> {
}
