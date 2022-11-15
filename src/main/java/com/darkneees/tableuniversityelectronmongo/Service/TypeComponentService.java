package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;

import java.util.List;

public interface TypeComponentService {

    TypeComponent addTypeComponent(TypeComponent typeComponent);
    List<TypeComponent> getAllTypeComponents();
    void deleteTypeComponent(String key);
}
