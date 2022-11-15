package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document
public class TypeComponent {

    private @MongoId String key;
    private String value;
    private List<Map<String, Field>> components = new ArrayList<>();

    public TypeComponent() {
    }

    public TypeComponent(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Map<String, Field>> getComponents() {
        return components;
    }

    public void setComponents(List<Map<String, Field>> components) {
        this.components = components;
    }

    public void addComponent(Map<String, Field> component) {
        this.components.add(component);
    }
}
