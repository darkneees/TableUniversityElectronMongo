package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document
public class TemplateField {

    private @MongoId String key;
    private HashMap<String, Field> fields = new HashMap<>();

    public TemplateField() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public HashMap<String, Field> getFields() {
        return fields;
    }

    public void setField(HashMap<String, Field> fields) {
        this.fields = fields;
    }

    public void addField(String key, Field field) {
        fields.put(key, field);
    }

    @Override
    public String toString() {
        return "TemplateField{" +
                "key='" + key + '\'' +
                ", field=" + fields +
                '}';
    }
}
