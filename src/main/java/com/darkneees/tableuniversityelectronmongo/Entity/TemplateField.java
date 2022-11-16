package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document
public class TemplateField {

    private @MongoId String key;
    private List<HashMap<String, Field>> fields = new ArrayList<>();

    public TemplateField() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<HashMap<String, Field>> getFields() {
        return fields;
    }

    public void setField(List<HashMap<String, Field>> fields) {
        this.fields = fields;
    }

    public void addField(String key, Field field) {
        HashMap<String, Field> fieldHashMap = new HashMap<>();
        fieldHashMap.put(key, field);
        fields.add(fieldHashMap);
    }

    @Override
    public String toString() {
        return "TemplateField{" +
                "key='" + key + '\'' +
                ", field=" + fields +
                '}';
    }
}
