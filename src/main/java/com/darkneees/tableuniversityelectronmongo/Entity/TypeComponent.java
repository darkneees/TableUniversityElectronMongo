package com.darkneees.tableuniversityelectronmongo.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class TypeComponent {

    private @MongoId String key;
    private String value;
    private List<Map<String, String>> components = new ArrayList<>();
    private Map<String, Field> fields = new HashMap<>();

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

    public List<Map<String, String>> getComponents() {
        return components;
    }

    public void setComponents(List<Map<String, String>> components) {
        this.components = components;
    }

    public void addComponent(Map<String, String> component) {
        this.components.add(component);
    }

    public Map<String, Field> getFields() {
        return fields;
    }

    public void setFields(Map<String, Field> fields) {
        this.fields = fields;
    }

    public void addField(String key, Field field) {
        fields.put(key, field);
    }
}
