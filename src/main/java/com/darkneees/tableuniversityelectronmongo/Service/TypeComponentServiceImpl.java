package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Field;
import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import com.darkneees.tableuniversityelectronmongo.Repository.TypeComponentRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.io.ObjectInput;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class TypeComponentServiceImpl implements TypeComponentService {

    private final TypeComponentRepository typeComponentRepository;

    public TypeComponentServiceImpl(TypeComponentRepository typeComponentRepository) {
        this.typeComponentRepository = typeComponentRepository;
    }

    @Override
    public TypeComponent addTypeComponent(TypeComponent typeComponent) {
        return typeComponentRepository.save(typeComponent);
    }

    @Override
    public List<TypeComponent> getAllTypeComponents() {
        return typeComponentRepository.findAll();
    }

    @Override
    public void deleteTypeComponent(String key) {
        typeComponentRepository.deleteById(key);
    }

    @Override
    public TypeComponent getTypeComponentByKey(String key) {
        return typeComponentRepository.findById(key).get();
    }

    public void addCollectionTypeComponent(String key, Map<String, String> data) {
        TypeComponent typeComponent = typeComponentRepository.findById(key).get();
        typeComponent.addComponent(data);
        typeComponentRepository.save(typeComponent);
    }

    public void addFieldsTypeComponent(Map<String, Field> map, String key) {
        Optional<TypeComponent> optionalTypeComponent = typeComponentRepository.findById(key);
        if(optionalTypeComponent.isPresent()) {
            TypeComponent typeComponent = optionalTypeComponent.get();
            map.keySet().stream().forEach((elem) -> {
                typeComponent.addField(elem, map.get(elem));
            });
            typeComponentRepository.save(typeComponent);
        }
    }
}
