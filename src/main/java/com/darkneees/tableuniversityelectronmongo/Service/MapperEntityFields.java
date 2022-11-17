package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Field;
import com.darkneees.tableuniversityelectronmongo.Entity.TemplateField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class MapperEntityFields {

    ObjectMapper mapper = new ObjectMapper();
    public TemplateField getTemplateFieldsForString(String data, String key) throws JsonProcessingException {

        TemplateField templateField = new TemplateField();
        templateField.setKey(key);

        Map<String, Object> map = mapper.readValue(data, new TypeReference<>() {
        });
        String fieldsData = mapper.writeValueAsString(map.get(key));
        Map<String, Field> fields = mapper.readValue(fieldsData, new TypeReference<>(){});
        fields.keySet().stream().forEach((e) -> {
            templateField.addField(e, fields.get(e));
        });
        return templateField;
    }

    public Map<String, String> createTypeComponent(String data) throws JsonProcessingException {
        Map<String, String> map = mapper.readValue(data, new TypeReference<>() {
        });
        return map;
    }
}
