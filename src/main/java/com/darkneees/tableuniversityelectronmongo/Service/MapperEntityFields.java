package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.Field;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;

import java.util.Map;

public class MapperEntityFields {

    ObjectMapper mapper = new ObjectMapper();

    public Map<String, Field> createTypeComponentFields(String data, String key) throws JsonProcessingException {
        Map<String, Map<String, Field>> map = mapper.readValue(data, new TypeReference<>() {
        });
        return map.get(key);
    }

    public Map<String, String> createTypeComponent(String data) throws JsonProcessingException {
        Map<String, String> map = mapper.readValue(data, new TypeReference<>() {
        });
        map.put("_id", String.valueOf(new ObjectId()));
        return map;
    }
}
