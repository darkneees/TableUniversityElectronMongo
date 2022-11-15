package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Component;
import com.darkneees.tableuniversityelectronmongo.Repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    @Override
    public Component addComponent(Component component) {
        Optional<Component> oldComponentOptional = componentRepository.findById(component.getKey());
        if(oldComponentOptional.isPresent()) {
            oldComponentOptional.get().getFields().add(component.getFields());
            return componentRepository.save(oldComponentOptional.get());
        } else return componentRepository.save(component);
    }
}
