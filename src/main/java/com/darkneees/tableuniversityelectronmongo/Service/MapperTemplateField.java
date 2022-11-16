package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Field;
import com.darkneees.tableuniversityelectronmongo.Entity.TemplateField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class MapperTemplateField {

    ObjectMapper mapper = new ObjectMapper();
    //{resitor=
// {key={value=name, required=true},
// key1={value=name1, required=true},
// key12={value=name12, required=true},
// key123={value=name123, required=true},
// key1234={value=name1234, required=true},
// key12345={value=name12345, required=false}}}
    public TemplateField getTemplateFieldsForString(String data, String key) throws JsonProcessingException {

        TemplateField templateField = new TemplateField();
        templateField.setKey(key);

        Map<String, Object> map = mapper.readValue(data, new TypeReference<>() {
        });
        String fieldsData = mapper.writeValueAsString(map.get(key));
        Map<String, Field> fields = mapper.readValue(fieldsData, new TypeReference<>(){});
        System.out.println(map);
        System.out.println(fields);
        fields.keySet().stream().forEach((e) -> {
            templateField.addField(e, fields.get(e));
        });
        return templateField;

    }
}
