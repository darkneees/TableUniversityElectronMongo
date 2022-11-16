package com.darkneees.tableuniversityelectronmongo.Repository;

import com.darkneees.tableuniversityelectronmongo.Entity.TemplateField;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateFieldRepository extends MongoRepository<TemplateField, String> {
}
