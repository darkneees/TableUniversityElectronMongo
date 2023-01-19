package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Field {

    private boolean required;
    private String typeData;

    public Field() {
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }


    public Field(boolean required, String typeData) {
        this.required = required;
        this.typeData = typeData;
    }

    public String getTypeData() {
        return typeData;
    }

    public void setTypeData(String typeData) {
        this.typeData = typeData;
    }

    @Override
    public String toString() {
        return "Field{" +
                "required=" + required +
                ", typeData='" + typeData + '\'' +
                '}';
    }
}
