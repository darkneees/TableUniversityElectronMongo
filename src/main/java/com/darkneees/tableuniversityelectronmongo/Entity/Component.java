package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class Component {

    private @MongoId String key;
    private List<Object> fields = new ArrayList<>();

    public Component() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Object> getFields() {
        return fields;
    }

    public void setFields(List<Object> fields) {
        this.fields = fields;
    }

    public void addField(Object field) {
        this.fields.add(field);
    }
}
