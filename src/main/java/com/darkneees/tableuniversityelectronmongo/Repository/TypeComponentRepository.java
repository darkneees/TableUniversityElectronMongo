package com.darkneees.tableuniversityelectronmongo.Repository;

import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeComponentRepository extends MongoRepository<TypeComponent, String> {
}
