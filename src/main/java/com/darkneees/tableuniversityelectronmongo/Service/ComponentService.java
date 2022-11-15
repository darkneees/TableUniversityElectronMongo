package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Component;

import java.util.List;

public interface ComponentService {

    List<Component> getAllComponents();
    Component addComponent(Component component);

}
