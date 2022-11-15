package com.darkneees.tableuniversityelectronmongo.Entity;

public class Field {

    private boolean required;
    private Object value;

    public Field() {
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Field(boolean required, Object value) {
        this.required = required;
        this.value = value;
    }
}
